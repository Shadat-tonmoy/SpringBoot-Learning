package com.stcodesapp.spring_boot_security.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Service
public class JWTService {

    private final static int TOKEN_EXPIRATION_IN_MILLIS = 30 * 60 * 1000; // 30 minutes
    private final static String TAG = "JWTService";
    private String secretKey = "";

    public JWTService() {
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

    private String generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println(TAG+" Generated key : " + secretKey);
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating secret key");
        }
    }

    private SecretKey getSigningKey() {
        byte[] secretKeyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(secretKeyByte);

    }


    public String extractUserName(String token) {
        String userName = extractClaims(token, Claims::getSubject);
        System.out.println(TAG+" extractUserName : "+userName);
        return userName;
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date tokenExpirationDate = getTokenExpirationDate(token);
        System.out.println(TAG+ " isTokenExpired : tokenExpirationDate : "+tokenExpirationDate);
        return tokenExpirationDate.before(new Date());
    }

    private Date getTokenExpirationDate(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token).getPayload();

    }


}
