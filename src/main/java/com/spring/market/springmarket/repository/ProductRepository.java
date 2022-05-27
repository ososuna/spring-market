package com.spring.market.springmarket.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.Product;
import com.spring.market.springmarket.model.dto.ProductDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements ProductRepositoryInterface {

  @Autowired
  private ProductCrudRepository productCrudRepository;

  @Override
  public List<ProductDto> getAll() {
    List<ProductDto> productDtos = new ArrayList<>();
    productCrudRepository.findAll()
      .forEach(product -> {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setStock(product.getStock());
        productDto.setActive(true);
        productDto.setCategoryId(product.getCategoryId());
        productDto.setCategory(null);
        productDtos.add(productDto);
      });
    return productDtos;
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
    Optional<Product> product = productCrudRepository.findById(productId);
    if (product.isPresent()) {
      ProductDto productDto = new ProductDto();
      productDto.setProductId(product.get().getId());
      productDto.setName(product.get().getName());
      productDto.setPrice(product.get().getPrice());
      productDto.setStock(product.get().getStock());
      productDto.setActive(true);
      productDto.setCategoryId(product.get().getCategoryId());
      productDto.setCategory(null);
      return Optional.of(productDto);
    } else {
      return Optional.empty();
    }
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
