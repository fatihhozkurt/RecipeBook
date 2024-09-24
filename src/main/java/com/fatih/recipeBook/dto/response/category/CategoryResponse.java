package com.fatih.recipeBook.dto.response.category;

import java.util.UUID;

public record CategoryResponse(

    UUID id,
    String name
) {
}