package com.fatih.recipeBook.controller.concretes;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.controller.abstracts.CategoryApi;
import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.dto.response.category.CategoryBaseResponse;
import com.fatih.recipeBook.dto.response.category.CategoryCardResponse;
import com.fatih.recipeBook.entity.CategoryEntity;
import com.fatih.recipeBook.mapper.CategoryMapper;
import com.fatih.recipeBook.service.abstracts.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Override
  public ResponseEntity<CategoryBaseResponse> createCategory(CategoryRequest categoryRequest) {
    CategoryEntity categoryEntity = CategoryMapper.INSTANCE.toEntity(categoryRequest);
    CategoryEntity createdCategory = categoryService.createCategory(categoryEntity);
    CategoryBaseResponse categoryBaseResponse = CategoryMapper.INSTANCE.toCategoryBaseResponse(createdCategory);
    return new ResponseEntity<>(categoryBaseResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<CategoryBaseResponse> updateCategory(CategoryRequest categoryRequest, UUID id) {
    CategoryEntity categoryEntity = CategoryMapper.INSTANCE.toEntity(categoryRequest);
    CategoryEntity updatedCategory = categoryService.updateCategory(categoryEntity, id);
    CategoryBaseResponse categoryBaseResponse = CategoryMapper.INSTANCE.toCategoryBaseResponse(updatedCategory);
    return new ResponseEntity<>(categoryBaseResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<HttpStatus> deleteCategory(UUID id) {
    categoryService.deleteCategory(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<CategoryBaseResponse> getCategoryById(UUID id) {
    CategoryEntity categoryEntity = categoryService.getCategoryById(id);
    CategoryBaseResponse categoryBaseResponse = CategoryMapper.INSTANCE.toCategoryBaseResponse(categoryEntity);
    return new ResponseEntity<>(categoryBaseResponse, HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<CategoryCardResponse> getCategoryCardById(UUID id) {
    CategoryEntity categoryEntity = categoryService.getCategoryById(id);
    CategoryCardResponse categoryCardResponse = CategoryMapper.INSTANCE.toCategoryCardResponse(categoryEntity);
    return new ResponseEntity<>(categoryCardResponse, HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<List<CategoryBaseResponse>> getAllCategories() {
    List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
    List<CategoryBaseResponse> categoryBaseResponses =
        CategoryMapper.INSTANCE.toCategoryBaseResponseList(categoryEntities);
    return new ResponseEntity<>(categoryBaseResponses, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<CategoryCardResponse>> getAllCategoryCards() {
    List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
    List<CategoryCardResponse> categoryCardResponses =
        CategoryMapper.INSTANCE.toCategoryCardResponseList(categoryEntities);
    return new ResponseEntity<>(categoryCardResponses, HttpStatus.OK);
  }
}
