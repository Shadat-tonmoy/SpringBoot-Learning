package com.stcodesapp.spring_boot_security.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private final static int TOKEN_EXPIRATION_IN_MILLIS = 30 * 60 * 1000; // 30 minutes
    private String secretKey = "";

    public JWTService(){
        secretKey = generateSecretKey();
    }

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_IN_MILLIS))
                .signWith(getSigningKey())
                .compact();

    }

    private String generateSecretKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println("Generated key : "+secretKey);
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error generating secret key");
        }
    }

    private Key getSigningKey() {
        byte[] secretKeyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyByte);

    }
}
