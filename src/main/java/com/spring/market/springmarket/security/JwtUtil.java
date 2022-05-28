package com.spring.market.springmarket.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

  private static final String SECRET = "e2fj7sxmsf78efmjfj";

  public String generateToken(UserDetails userDetails) {
    return Jwts
      .builder()
      .setSubject(userDetails.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
      .signWith(SignatureAlgorithm.HS512, SECRET)
      .compact();
  }

  public boolean validateToken(String token, UserDetails userDetails) {
    return userDetails.getUsername().equals(getUsernameFromToken(token)) && !isTokenExpired(token);
  }

  public String getUsernameFromToken(String token) {
    return getClaimsFromToken(token).getSubject();
  }

  public boolean isTokenExpired(String token) {
    return getClaimsFromToken(token).getExpiration().before(new Date());
  }

  private Claims getClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
  }

}
