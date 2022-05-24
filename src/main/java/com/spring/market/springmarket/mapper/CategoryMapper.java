package com.spring.market.springmarket.mapper;

import com.spring.market.springmarket.model.Category;
import com.spring.market.springmarket.model.dto.CategoryDto;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  @Mappings({
    @Mapping(source = "id", target = "categoryId"),
    @Mapping(source = "description", target = "category"),
    @Mapping(source = "active", target = "active")
  })
  CategoryDto toCategoryDto(Category category);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Category toCategory(CategoryDto categorydTO);

}
