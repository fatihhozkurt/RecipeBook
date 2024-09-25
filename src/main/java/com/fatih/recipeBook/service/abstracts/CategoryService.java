package com.fatih.recipeBook.service.abstracts;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.entity.CategoryEntity;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
  CategoryEntity createCategory(CategoryEntity categoryEntity);

  List<CategoryEntity> getAllCategories();

  CategoryEntity getCategoryById(UUID id);

  CategoryEntity updateCategory(CategoryEntity categoryEntity, UUID id);

  void deleteCategory(UUID id);
}
