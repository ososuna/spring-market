package com.spring.market.springmarket.controller;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.dto.ProductDto;
import com.spring.market.springmarket.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
  
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<ProductDto> getAll() {
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<ProductDto> getProduct(@PathVariable("id") int productId) {
    return productService.getProduct(productId);
  }

}
