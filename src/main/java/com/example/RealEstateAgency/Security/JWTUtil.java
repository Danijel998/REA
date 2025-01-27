package com.example.RealEstateAgency.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JWTUtil {

    private static final String SECRET_KEY = "5e5811e1deeb085b9441bc270733c8efddd64a58dcba3f77f52fe252b6aa04816f485b0775b2ebd5ededd2321cf7b6689ab9e44f97b0df2d38cf1617f86ec7f8158e76c57b0c043ee8429490de7300ff70a5538bdd813f248683a93be65e7f31df1d5d989300d0b4a425ae9d0451bff1d9546be92eff10172944c89387087ae598bbbc6a2cda573be94254c725e320c9251f652da79ff00e1882b4d654b06154443256611f9cc036fdde1fe7c315ff827bddcda2237a6292177728bbb5367250677f3a147460640b1e10eb5730cab5d4e242b3e411a3b22b28d548f7d5c8f36111add509b8a23488995679fb96361d4440eeeffe37b03ae7b4961f2afa8ef8e3";
    private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);


    public String generateToken(String username) {

        Map<String, Objects> claims = new HashMap<>();

        JwtBuilder jwt = Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+3600000))
                .and()
                .signWith(generateJWTSecretKey());
        return jwt.compact();
    }


    public SecretKey generateJWTSecretKey() {

        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            //SECRET_KEY = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[32];  // 32 bajta za HMAC-SHA256
        secureRandom.nextBytes(keyBytes);  // Popunjava niz sa slučajnim bajtovima
        return Keys.hmacShaKeyFor(keyBytes);  // Kreiraj HMAC ključ
/*
         //Convert the static word to a byte array
        //byte[] keyBytes = SECRET_KEY.getBytes();

        //Ensure the key length is compatible with the algorithm
        byte[] keyBytesPadded = new byte[32];
        System.arraycopy(keyBytes, 0, keyBytesPadded, 0, Math.min(keyBytes.length, 32));

        // If the key is shorter than 32 bytes, fill the remaining bytes
        if (keyBytes.length < 32) {
            Arrays.fill(keyBytesPadded, keyBytes.length, 32, (byte) 0);
        }

        //Generate the SecretKey using the static word
        return Keys.hmacShaKeyFor(keyBytesPadded);*/
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
        try {
            // Loguj token koji pokušavaš da parsiraš
            logger.info("Parsing JWT: " + token);
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY.getBytes())
                    //.verifyWith(generateJWTSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (MalformedJwtException e) {
            // Loguj grešku kada je token nevalidan
            logger.error("Invalid JWT token: " + token);
            throw e;
        }
    }
}
