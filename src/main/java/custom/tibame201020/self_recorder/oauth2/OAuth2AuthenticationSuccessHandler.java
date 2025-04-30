package custom.tibame201020.self_recorder.oauth2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * OAuth2 驗證成功處理器。
 * 用於處理 OAuth2 驗證成功的情況。
 */
@Component
public class OAuth2AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Value("${oauth2.redirect-url}")
    private String redirectUrl;

    /**
     * 驗證成功時呼叫。
     *
     * @param request        HTTP 請求
     * @param response       HTTP 回應
     * @param authentication 驗證資訊
     * @throws IOException      IO 異常
     * @throws ServletException Servlet 異常
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        // Customize the redirect URL after successful authentication

        // print info for oauth2 authentication
        System.out.println("Authentication success: " + authentication.getName());
        System.out.println("Authentication success: " + authentication.getPrincipal());
        System.out.println("Authentication success: " + authentication.getAuthorities());
        System.out.println("Authentication success: " + authentication.getDetails());
        System.out.println("Authentication success: " + authentication.getCredentials());
        // pring info fot oauth2 request
        System.out.println("Request: " + request.getMethod());
        System.out.println("Request: " + request.getRequestURI());
        System.out.println("Request: " + request.getQueryString());
        System.out.println("Request: " + request.getServletPath());
        // pring info for oauth2 response
        System.out.println("Response: " + response.getStatus());
        System.out.println("Response: " + response.getContentType());
        System.out.println("Response: " + response.getCharacterEncoding());
        System.out.println("Response: " + response.getHeaderNames());
        System.out.println("Response: " + response.getHeader("Content-Type"));


        String targetUrl = redirectUrl; // Redirect to the home page or any other desired URL
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
