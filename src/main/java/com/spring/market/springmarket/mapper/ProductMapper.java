package com.spring.market.springmarket.mapper;

import java.util.List;

import com.spring.market.springmarket.model.Product;
import com.spring.market.springmarket.model.dto.ProductDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  
  @Mappings({
    @Mapping(source = "id", target = "productId"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "categoryId", target = "categoryId"),
    @Mapping(source = "price", target = "productPrice"),
    @Mapping(source = "stock", target = "stock"),
    @Mapping(source = "active", target = "active"),
    @Mapping(source = "category", target = "category")
  })
  ProductDto toProductDto(Product product);

  List<ProductDto> toProductDtoList(List<Product> products);  
  
  @InheritInverseConfiguration
  @Mapping(target = "code", ignore = true)
  Product toProduct(ProductDto productDto);
  
}
