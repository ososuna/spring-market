package com.spring.market.springmarket.repository;

import java.util.List;
import java.util.Optional;

import com.spring.market.springmarket.model.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

  List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

  Optional<List<Product>> findByStockLessThanAndActive(int stock, boolean active);

}
