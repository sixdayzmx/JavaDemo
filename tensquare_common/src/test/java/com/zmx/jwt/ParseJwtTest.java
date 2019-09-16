package com.zmx.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims=Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1Njg1MTMyMjksImV4cCI6MTU2ODUxMzI4OSwicm9sZSI6ImFkbWluIn0.1G28LX9trmEOII2QgrBHd3H5ki8y48g8gDVPaAxMtkQ")
                .getBody();
        System.out.println("用户id:"+claims.getId());
        System.out.println("用户名："+claims.getSubject());
        System.out.println("登录时间"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户的角色"+claims.get("role"));
    }
}
