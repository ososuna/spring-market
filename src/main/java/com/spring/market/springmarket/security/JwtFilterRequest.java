package com.spring.market.springmarket.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.market.springmarket.service.MarketUserDetailsService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

  private final JwtUtil jwtUtil;
  private final MarketUserDetailsService marketUserDetailsService;

  public JwtFilterRequest(
    JwtUtil jwtUtil,
    MarketUserDetailsService marketUserDetailsService
  ) {
    this.jwtUtil = jwtUtil;
    this.marketUserDetailsService = marketUserDetailsService;
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    String header = request.getHeader("Authorization");
    if (header != null && header.startsWith("Bearer")) {
      String token = header.substring(7);
      String username = jwtUtil.getUsernameFromToken(token);
      if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        UserDetails userDetails = marketUserDetailsService.loadUserByUsername(username);
        if (jwtUtil.validateToken(token, userDetails)) {
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities()
          );
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      }
    }
    filterChain.doFilter(request, response);
  }
}
