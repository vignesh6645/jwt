package com.example.demo.Util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Decode {

    public  static String decode(String token) throws UnsupportedEncodingException{
        String payload = token.split("\\.")[1];
        return new String(Base64.decodeBase64(payload),"UTF-8");
    }

}
