package com.encore.classProject_ordering.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private int expiration;


    public String createToken(String email, String role){            //token은 String 타입
//        claims : 클레임은 토큰 사용자에 대한 속성이나 데이터 포함; 주로 payload를 의미
        Claims claims = Jwts.claims().setSubject(email);
        log.debug("expiration"+ expiration);
        log.debug("secretKey"+ secretKey);
        claims.put("role", role);
        Date now= new Date();
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setClaims(claims);
        jwtBuilder.setIssuedAt(now);
        jwtBuilder.setExpiration(new Date(now.getTime()+ expiration*60*1000L));
        jwtBuilder.signWith(SignatureAlgorithm.HS256,"mysecret");
        return jwtBuilder.compact();
//같은 내용
     /*   String token = Jwts.builder()
                        .setClaims(claims)
                        .setIssuedAt(now)
                        .setExpiration(new Date(now.getTime()+ 30*60*1000L))
                        .signWith(SignatureAlgorithm.HS256,"mysecret")
                        .compact();
        return token;*/



    }
}
