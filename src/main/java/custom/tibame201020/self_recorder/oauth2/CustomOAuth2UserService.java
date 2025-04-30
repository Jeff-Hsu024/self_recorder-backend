package custom.tibame201020.self_recorder.oauth2;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.provider.SnowflakeIdProvider;
import custom.tibame201020.self_recorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 自定義 OAuth2 使用者服務。
 * 用於處理 OAuth2 登入的使用者資訊。
 */
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SnowflakeIdProvider snowflakeIdProvider;

    /**
     * 載入使用者。
     *
     * @param userRequest OAuth2 使用者請求
     * @return OAuth2 使用者
     * @throws OAuth2AuthenticationException OAuth2 驗證異常
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(oAuth2User);
    }

    /**
     * 處理 OAuth2 使用者。
     *
     * @param oAuth2User OAuth2 使用者
     * @return OAuth2 使用者
     */
    private OAuth2User processOAuth2User(OAuth2User oAuth2User) {
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setId(snowflakeIdProvider.nextId());
            user.setUsername(email);
            user.setEmail(email);
            user.setName(name);
            userRepository.save(user);
        }
        return oAuth2User;
    }
}
