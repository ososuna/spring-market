package com.spring.market.springmarket.security;

import com.spring.market.springmarket.service.MarketUserDetailsService;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final MarketUserDetailsService marketUserDetailsService;

  public SecurityConfig(MarketUserDetailsService marketUserDetailsService) {
    this.marketUserDetailsService = marketUserDetailsService;
  }

  @Override
  protected void configure(
    AuthenticationManagerBuilder auth
  ) throws Exception {
    auth.userDetailsService(marketUserDetailsService);
  }

}
