package com.EMPLOYEE.JWT.Util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class GenrateToken {

    public static String generateToken(String userEmail, String subject, String userPassword) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setSubject(subject).claim("userEmail", userEmail)
                .claim("userPassword", userPassword).setIssuedAt(now);
        return builder.compact();
    }
}
