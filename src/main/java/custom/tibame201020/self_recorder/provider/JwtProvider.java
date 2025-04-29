package custom.tibame201020.self_recorder.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * JWT 提供者，用於生成和解析 JWT token。
 */
@Component
public class JwtProvider {

    /**
     * JWT secret key.
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * JWT expiration time in milliseconds.
     */
    @Value("${jwt.expiration}")
    private long jwtExpiration;

    /**
     * JWT refresh token expiration time in milliseconds.
     */
    @Value("${jwt.refresh-token.expiration}")
    private long refreshExpiration;

    /**
     * 生成 JWT token。
     *
     * @param username 使用者名稱
     * @return JWT token
     */
    public String generateToken(String username) {
        return generateToken(new HashMap<>(), username);
    }

    /**
     * 生成 JWT token，可以添加額外的 claims。
     *
     * @param extraClaims 額外的 claims
     * @param username    使用者名稱
     * @return JWT token
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            String username
    ) {
        return buildToken(extraClaims, username, jwtExpiration);
    }

    /**
     * 生成 JWT refresh token。
     *
     * @param username 使用者名稱
     * @return JWT refresh token
     */
    public String generateRefreshToken(
            String username
    ) {
        return buildToken(new HashMap<>(), username, refreshExpiration);
    }

    /**
     * 建立 JWT token。
     *
     * @param extraClaims 額外的 claims
     * @param username    使用者名稱
     * @param expiration  token 過期時間
     * @return JWT token
     */
    private String buildToken(
            Map<String, Object> extraClaims,
            String username,
            long expiration
    ) {

        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    /**
     * 從 JWT token 中提取使用者名稱。
     *
     * @param token JWT token
     * @return 使用者名稱
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * 從 JWT token 中提取 claim。
     *
     * @param token          JWT token
     * @param claimsResolver claim 解析器
     * @param <T>            claim 類型
     * @return claim 值
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 從 JWT token 中提取所有 claims。
     *
     * @param token JWT token
     * @return 所有 claims
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 取得 signing key。
     *
     * @return signing key
     */
    private Key getSignInKey() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
