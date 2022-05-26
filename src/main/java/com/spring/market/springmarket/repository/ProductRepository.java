package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.dto.ProductDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

  @Autowired
  private ProductCrudRepository productCrudRepository;

  @Override
  public List<ProductDto> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<List<ProductDto>> getByCategoryId(int categoryId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<List<ProductDto>> getScarseProducts(int quantity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<ProductDto> getProduct(int productId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ProductDto save(ProductDto product) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void delete(int productId) {
    // TODO Auto-generated method stub
    
  }

}
