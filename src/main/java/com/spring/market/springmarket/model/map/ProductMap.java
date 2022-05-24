package com.spring.market.springmarket.model.map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductMap {
  
  private int productId;
  private String name;
  private int categoryId;
  private double price;
  private int stock;
  private boolean active;
  private CategoryMap category;

}
