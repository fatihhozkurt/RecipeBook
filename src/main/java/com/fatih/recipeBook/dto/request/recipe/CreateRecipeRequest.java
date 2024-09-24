package com.fatih.recipeBook.dto.request.recipe;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.dto.request.image.ImageRequest;

public record CreateRecipeRequest(

    @Valid
    RecipeRequest recipeRequest,

    @Valid
    CategoryRequest categoryRequest,

    @Valid
    @NotEmpty(message = "{backend.constraints.NotEmpty.message}")
    List<ImageRequest> imageRequests

) {
}
