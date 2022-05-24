package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.dto.ProductDto;

public interface ProductRepositoryInterface {
  
  List<ProductDto> getAll();
  Optional<List<ProductDto>> getByCategoryId(int categoryId);
  Optional<List<ProductDto>> getScarseProducts(int quantity);
  Optional<ProductDto> getProduct(int productId);
  ProductDto save(ProductDto product);
  void delete(int productId);

}
