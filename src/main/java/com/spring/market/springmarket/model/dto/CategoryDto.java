package com.spring.market.springmarket.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

  private int categoryId;
  private String category;
  private boolean active;

}
