package custom.tibame201020.self_recorder.oauth2;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OAuth2 驗證失敗處理器。
 * 用於處理 OAuth2 驗證失敗的情況。
 */
@Component
public class OAuth2AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * 驗證失敗時呼叫。
     *
     * @param request  HTTP 請求
     * @param response HTTP 回應
     * @param exception 驗證異常
     * @throws IOException      IO 異常
     * @throws ServletException Servlet 異常
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // Customize the error redirect URL or error handling
        String targetUrl = "/login?error=true"; // Redirect to the login page with an error parameter
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
