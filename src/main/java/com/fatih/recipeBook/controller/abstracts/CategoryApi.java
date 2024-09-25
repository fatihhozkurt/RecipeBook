package com.fatih.recipeBook.controller.abstracts;

import static com.fatih.recipeBook.constants.URLConstants.ALL;
import static com.fatih.recipeBook.constants.URLConstants.BASE;
import static com.fatih.recipeBook.constants.URLConstants.CATEGORY;
import static com.fatih.recipeBook.constants.URLConstants.ID;
import static com.fatih.recipeBook.constants.URLConstants.PAGE;
import static com.fatih.recipeBook.constants.URLConstants.REQUEST;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.dto.response.category.CategoryBaseResponse;
import com.fatih.recipeBook.dto.response.category.CategoryCardResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(CATEGORY)
public interface CategoryApi {

  @PostMapping(BASE + REQUEST)
  ResponseEntity<CategoryBaseResponse> createCategory(@Valid @RequestBody CategoryRequest categoryRequest);

  @PutMapping(BASE + REQUEST + ID)
  ResponseEntity<CategoryBaseResponse> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest,
                                                      @RequestParam("id") UUID id);

  @DeleteMapping(BASE + ID)
  ResponseEntity<HttpStatus> deleteCategory(@RequestParam("id") UUID id);

  @GetMapping(BASE + ID)
  ResponseEntity<CategoryBaseResponse> getCategoryById(@RequestParam("id") UUID id);

  @GetMapping(PAGE + ID)
  ResponseEntity<CategoryCardResponse> getCategoryCardById(@RequestParam("id") UUID id);

  @GetMapping(BASE + ALL)
  ResponseEntity<List<CategoryBaseResponse>> getAllCategories();

  @GetMapping(PAGE + ALL)
  ResponseEntity<List<CategoryCardResponse>> getAllCategoryCards();
}
