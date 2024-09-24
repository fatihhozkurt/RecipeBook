package com.fatih.recipeBook.dto.response.recipe;

import com.fatih.recipeBook.dto.response.category.CategoryResponse;

public record CategoryRecipesResponse(
    AllRecipesResponse allRecipesResponse,
    CategoryResponse categoryResponse
) {

}
