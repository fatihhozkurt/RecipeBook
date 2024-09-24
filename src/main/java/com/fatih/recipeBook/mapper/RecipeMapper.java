package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.recipe.CreateRecipeRequest;
import com.fatih.recipeBook.dto.request.recipe.RecipeRequest;
import com.fatih.recipeBook.dto.response.recipe.AllRecipesResponse;
import com.fatih.recipeBook.dto.response.recipe.CategoryRecipesResponse;
import com.fatih.recipeBook.dto.response.recipe.RecipeDetailsResponse;
import com.fatih.recipeBook.dto.response.recipe.RecipeResponse;
import com.fatih.recipeBook.entity.RecipeEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {
  RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

  RecipeEntity toEntity(RecipeRequest recipeRequest);

  RecipeEntity createRecipeToEntity(CreateRecipeRequest createRecipeRequest);

  RecipeResponse toRecipeResponse(RecipeEntity recipeEntity);

  List<RecipeResponse> toRecipeResponseList(List<RecipeEntity> recipeEntities);

  RecipeDetailsResponse toRecipeDetailsResponse(RecipeEntity recipeEntity);

  List<CategoryRecipesResponse> toCategoryRecipesResponse(List<RecipeEntity> recipeEntities);

  List<AllRecipesResponse> toAllRecipesResponse(List<RecipeEntity> recipeEntities);



}
