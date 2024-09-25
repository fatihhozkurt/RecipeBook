package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.dto.response.category.CategoryBaseResponse;
import com.fatih.recipeBook.dto.response.category.CategoryCardResponse;
import com.fatih.recipeBook.entity.CategoryEntity;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  CategoryEntity toEntity(CategoryRequest categoryRequest);

  CategoryBaseResponse toCategoryBaseResponse(CategoryEntity categoryEntity);

  CategoryCardResponse toCategoryCardResponse(CategoryEntity category);

  List<CategoryBaseResponse> toCategoryBaseResponseList(List<CategoryEntity> categoryEntities);

  List<CategoryCardResponse> toCategoryCardResponseList(List<CategoryEntity> categoryEntities);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateToExistingCategoryWithIgnoringNulls(CategoryEntity requestedCategory, @MappingTarget CategoryEntity foundedCategory);

}
