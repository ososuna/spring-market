package com.spring.market.springmarket.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
  
  private int productId;
  private String name;
  private int categoryId;
  private double price;
  private int stock;
  private boolean active;
  private CategoryDto category;

}
