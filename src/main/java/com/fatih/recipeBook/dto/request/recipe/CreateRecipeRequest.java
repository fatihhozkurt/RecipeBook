package com.fatih.recipeBook.dto.request.recipe;

import jakarta.validation.Valid;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;

public record CreateRecipeRequest(

    @Valid
    RecipeRequest recipeRequest,

    @Valid
    CategoryRequest categoryRequest
) {
}
