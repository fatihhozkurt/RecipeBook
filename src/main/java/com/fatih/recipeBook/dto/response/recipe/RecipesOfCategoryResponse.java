package com.fatih.recipeBook.dto.response.recipe;

import com.fatih.recipeBook.dto.response.category.CategoryBaseResponse;

public record RecipesOfCategoryResponse(
    AllRecipesResponse allRecipesResponse,
    CategoryBaseResponse categoryBaseResponse
) {

}
