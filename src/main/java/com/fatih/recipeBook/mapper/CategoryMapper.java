package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.dto.response.category.CategoryResponse;
import com.fatih.recipeBook.entity.CategoryEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryEntity toEntity(CategoryRequest categoryRequest);

  CategoryResponse toCategoryResponse(CategoryEntity categoryEntity);

  List<CategoryResponse> toCategoryResponseList(List<CategoryEntity> categoryEntities);

}
