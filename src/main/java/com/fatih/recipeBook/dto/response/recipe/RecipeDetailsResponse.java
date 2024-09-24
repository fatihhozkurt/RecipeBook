package com.fatih.recipeBook.dto.response.recipe;

import com.fatih.recipeBook.dto.response.category.CategoryResponse;
import com.fatih.recipeBook.dto.response.image.ImageCardResponse;

public record RecipeDetailsResponse(

    RecipeResponse recipeResponse,
    ImageCardResponse imageCardResponse,
    CategoryResponse categoryResponse

) {
}
