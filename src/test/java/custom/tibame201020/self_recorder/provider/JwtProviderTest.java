package custom.tibame201020.self_recorder.provider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
        "jwt.secret=404E635266556A586E3272357538782F413F4428472B4B6250655368566D5970",
        "jwt.expiration=3600000",
        "jwt.refresh-token.expiration=86400000"
})
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    private String username;

    @BeforeEach
    void setUp() {
        username = "testuser";
    }

    @Test
    void generateToken() {
        String token = jwtProvider.generateToken(username);
        assertNotNull(token);
    }

    @Test
    void extractUsername() {
        String token = jwtProvider.generateToken(username);
        String extractedUsername = jwtProvider.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    void generateRefreshToken() {
        String refreshToken = jwtProvider.generateRefreshToken(username);
        assertNotNull(refreshToken);
    }

    @Test
    void validateToken() {
        String token = jwtProvider.generateToken(username);
        assertDoesNotThrow(() -> jwtProvider.extractUsername(token));
    }
}
