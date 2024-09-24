package com.fatih.recipeBook.dto.response.recipe;

import com.fatih.recipeBook.dto.response.image.ImageCardResponse;

public record AllRecipesResponse(

    String name,
    ImageCardResponse imageCardResponse
) {
}
