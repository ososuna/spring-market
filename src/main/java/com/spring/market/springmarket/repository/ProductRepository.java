package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  
  private ProductCrudRepository productCrudRepository;

  public List<Product> getAll() {
    return (List<Product>) productCrudRepository.findAll();
  }

  public List<Product> getByCategory(int categoryId) {
    return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
  }

  public Optional<List<Product>> getNoStock(int stock, boolean active) {
    return productCrudRepository.findByStockLessThanAndActive(stock, active);
  }

  public Optional<Product> getProduct(int idProduct) {
    return productCrudRepository.findById(idProduct);
  }

  public Product save(Product product) {
    return productCrudRepository.save(product);
  }

  public void delete(int idProduct) {
    productCrudRepository.deleteById(idProduct);
  }

}
