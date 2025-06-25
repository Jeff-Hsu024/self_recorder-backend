package custom.tibame201020.self_recorder.service;

import custom.tibame201020.self_recorder.entity.User;
import custom.tibame201020.self_recorder.oauth2.CustomOAuth2UserService;
import custom.tibame201020.self_recorder.oauth2.OAuth2AuthenticationFailureHandler;
import custom.tibame201020.self_recorder.oauth2.OAuth2AuthenticationSuccessHandler;
import custom.tibame201020.self_recorder.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 使用者服務。
 * 提供使用者相關操作，例如取得、建立、更新和刪除使用者。
 */
@Service
@EnableWebSecurity
public class UserService {

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private OAuth2AuthenticationFailureHandler oAuth2AuthenticationFailureHandler;

    @Autowired
    private UserRepository userRepository;

    /**
     * 配置 Spring Security 過濾器鏈。
     *
     * @param http HttpSecurity 物件
     * @return SecurityFilterChain 物件
     * @throws Exception 異常
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                        .successHandler(oAuth2AuthenticationSuccessHandler)
                        .failureHandler(oAuth2AuthenticationFailureHandler)
                );

        http.addFilterBefore(new GenericFilterBean() {

            @Override
            public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
                    throws IOException, ServletException {

                Authentication fakeAuthentication = 
                new UsernamePasswordAuthenticationToken("dev_user", null, Collections.singletonList(new SimpleGrantedAuthority("role")));

                SecurityContextHolder.getContext().setAuthentication(fakeAuthentication);

                arg2.doFilter(arg0, arg1);
            }
            
        }, OAuth2LoginAuthenticationFilter.class);

        return http.build();
    }

    /**
     * 取得所有使用者。
     *
     * @return 使用者列表
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 根據 ID 取得使用者。
     *
     * @param id 使用者 ID
     * @return 使用者
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * 建立使用者。
     *
     * @param user 使用者
     * @return 使用者
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 更新使用者。
     *
     * @param user 使用者
     * @return 使用者
     */
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 根據 ID 刪除使用者。
     *
     * @param id 使用者 ID
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
