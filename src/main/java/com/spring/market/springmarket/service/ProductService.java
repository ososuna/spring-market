package com.spring.market.springmarket.service;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.dto.ProductDto;
import com.spring.market.springmarket.repository.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
  
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductDto> getAll() {
    return productRepository.getAll();
  }

  public Optional<ProductDto> getProduct(int productId) {
    System.out.println(productId);
    return productRepository.getProduct(productId);
  }

  public Optional<List<ProductDto>> getByCategoryId(int categoryId) {
    return productRepository.getByCategoryId(categoryId);
  }

  public ProductDto save(ProductDto product) {
    return productRepository.save(product);
  }

  public boolean delete(int productId) {
    return getProduct(productId)
      .map(product -> {
        productRepository.delete(productId);
        return true;
      }).orElse(false);
  }

}
