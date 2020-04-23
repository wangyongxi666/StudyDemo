package com.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @ClassName jwt
 * @Description (这里用一句话描述这个类的作用)
 * @Author YongXi.Wang
 * @Date  2020年02月18日 20:34
 * @Version 1.0.0
*/
public class jwtTest {

  public static void main(String[] args) {

    //系统当前时间
    long now = System.currentTimeMillis();
    Date date = new Date(now);

    //加密
    JwtBuilder jwtBuilder = Jwts.builder()
            .setId("66")
            .setSubject("黑马程序员")
            .setIssuedAt(new Date())
            //.setExpiration(date)
            .claim("roles","admin")
            .claim("company","itheima")
            .signWith(SignatureAlgorithm.HS256, "itheima");

    String jwtToken = jwtBuilder.compact();
    System.out.println(jwtToken);

    //解析
    Claims itheima = Jwts.parser().setSigningKey("itheima").parseClaimsJws(jwtToken).getBody();
    System.out.println(itheima);
  }

}
