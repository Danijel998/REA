package com.example.RealEstateAgency.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    private static final String SECRET_KET = "Hello";

    public String generateToken(String username) {
        JwtBuilder jwt = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7000000))
                .signWith(SignatureAlgorithm.HS256, generateJWTSecretKey());
        return jwt.compact();
    }

    public SecretKey generateJWTSecretKey() {
        //Convert the static word to a byte array
        byte[] keyBytes = SECRET_KET.getBytes();

        //Ensure the key length is compatible with the algorithm
        byte[] keyBytesPadded = new byte[32];
        System.arraycopy(keyBytes, 0, keyBytesPadded, 0, Math.min(keyBytes.length, 3));

        //Generate the SecretKey using the static word
        return Keys.hmacShaKeyFor(keyBytesPadded);
    }

    public boolean validateToken(String username, String token) {
        return (username.equals(getUsername(token)) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(generateJWTSecretKey()).build()
                .parseClaimsJws(token).getBody();
    }
}
