package com.example.demo.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class GenerateToken {

    public static String generateToken(String userPassword) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .claim("userPassword", userPassword)
                .setIssuedAt(now);
        return builder.compact();
    }
}
