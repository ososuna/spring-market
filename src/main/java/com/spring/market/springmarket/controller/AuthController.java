package com.spring.market.springmarket.controller;

import com.spring.market.springmarket.model.dto.AuthenticationRequestDto;
import com.spring.market.springmarket.model.dto.AuthenticationResponseDto;
import com.spring.market.springmarket.security.JwtUtil;
import com.spring.market.springmarket.service.MarketUserDetailsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final MarketUserDetailsService marketUserDetailsService;
  private final JwtUtil jwtUtil;

  public AuthController(
    AuthenticationManager authenticationManager,
    MarketUserDetailsService marketUserDetailsService,
    JwtUtil jwtUtil
  ) {
    this.authenticationManager = authenticationManager;
    this.marketUserDetailsService = marketUserDetailsService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping
  public ResponseEntity<AuthenticationResponseDto> createToken(
    @RequestBody AuthenticationRequestDto request
  ) {
    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          request.getUsername(),
          request.getPassword()
        )
      );
      UserDetails userDetails = marketUserDetailsService.loadUserByUsername(
        request.getUsername()
      );
      String token = jwtUtil.generateToken(userDetails);
      return new ResponseEntity<>(new AuthenticationResponseDto(token), HttpStatus.OK);
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }

}
