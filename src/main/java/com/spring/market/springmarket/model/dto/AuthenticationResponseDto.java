package com.spring.market.springmarket.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationResponseDto {
  
  private String jwt;

  public AuthenticationResponseDto(String jwt) {
    this.jwt = jwt;
  }

}
