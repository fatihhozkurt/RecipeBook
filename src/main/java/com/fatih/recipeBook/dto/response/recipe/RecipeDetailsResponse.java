package com.fatih.recipeBook.dto.response.recipe;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.dto.response.category.CategoryCardResponse;
import com.fatih.recipeBook.dto.response.image.ImageCardResponse;

public record RecipeDetailsResponse(

    UUID id,
    String name,
    String description,
    Integer readingTime,
    List<ImageCardResponse> imageCardResponses,
    CategoryCardResponse categoryCardResponse
) {
}
