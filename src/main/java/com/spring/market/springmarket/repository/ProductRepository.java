package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.Product;

public class ProductRepository {
  
  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }

  public List<Product> getByCategoryId(int categoryId) {
    return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
  }

  public Optional<List<Product>> getByStockLessThanAndActive(int stock, boolean active) {
    return productCrudRepository.findByStockLessThanAndActive(stock, active);
  }

}
