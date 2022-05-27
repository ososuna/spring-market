package com.spring.market.springmarket.controller;

import java.util.List;

import com.spring.market.springmarket.model.dto.ProductDto;
import com.spring.market.springmarket.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {
  
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  @ApiOperation("Get all supermarket products")
  @ApiResponse(code = 200, message = "Successfully retrieved list of products")
  public ResponseEntity<List<ProductDto>> getAll() {
    return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ApiOperation("Get supermarket product by id")
  @ApiResponses({
      @ApiResponse(code = 200, message = "Successfully retrieved product"),
      @ApiResponse(code = 404, message = "Product not found")
  })
  public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int productId) {
    return productService.getProduct(productId)
      .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}
