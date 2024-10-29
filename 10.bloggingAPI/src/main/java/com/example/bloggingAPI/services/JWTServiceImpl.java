package com.example.bloggingAPI.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServiceImpl implements JWTService {


    @Value("${security.jwt.secret-key}")
    private String jwtSecret;

    @Value(("${security.jwt.expiration-time}"))
    private long jwtExpirationTime;


    // token generation

    @Override
    public String generateToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails);
    }

    @Override
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails);
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String extractUserName(String token) {
        String subject = extractClaim(token,Claims::getSubject);
        return subject;
    }

    @Override
    public long getExpireTime(String token) {
        return extractClaim(token,Claims::getExpiration).getTime();
    }

    private Date extractExpireDate(String token){
        Date expireDate = extractClaim(token,Claims::getExpiration);
        return expireDate;
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
        Claims allClaims = extractAllClaims(token);
        return claimResolver.apply(allClaims);
    }

    private Claims extractAllClaims(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    private Key getSigninKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        Date expireDate = extractExpireDate(token);
        return expireDate.before(new Date());
    }
}
