package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.map.ProductMap;

public interface ProductRepositoryInterface {
  
  List<ProductMap> getAll();
  Optional<List<ProductMap>> getByCategoryId(int categoryId);
  Optional<List<ProductMap>> getScarseProducts(int quantity);
  Optional<ProductMap> getProduct(int productId);
  ProductMap save(ProductMap product);
  void delete(int productId);

}
