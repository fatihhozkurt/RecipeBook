package com.fatih.recipeBook.dto.response.recipe;

import java.util.UUID;

public record RecipeResponse(

    UUID id,
    String name,
    String description,
    Integer readingTime
) {
}
