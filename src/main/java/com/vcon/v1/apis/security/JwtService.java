package com.vcon.v1.apis.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.vcon.v1.apis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.access-token-expiration}")
    private long accessTokenExpiration; // in milliseconds

    @Value("${jwt.refresh-token-expiration}")
    private long refreshTokenExpiration; // in milliseconds

    public String generateAccessToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("userId", user.getUserId()) // Add user ID as a claim
                .withClaim("roles", user.getRole())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .sign(algorithm);
    }


    public String generateRefreshToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        return JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .sign(algorithm);
    }

    public String extractUsername(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            logger.error("Error verifying JWT token: {}", e.getMessage());
            return null;
        }
    }

    public String extractRole(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getClaim("roles")
                    .asString();
        } catch (JWTVerificationException e) {
            logger.error("Error verifying JWT token: {}", e.getMessage());
            return null;
        }
    }

    public boolean isTokenValid(String token, User user) {
        final String username = extractUsername(token);
        return (username != null && username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getExpiresAt();
        } catch (JWTVerificationException e) {
            logger.error("Error verifying JWT token: {}", e.getMessage());
            return new Date(0); // Return an old date to indicate expiration
        }
    }

    public long getExpirationTime() {
        return accessTokenExpiration;
    }
}