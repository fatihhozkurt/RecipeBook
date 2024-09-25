package com.fatih.recipeBook.dto.response.category;

import java.util.UUID;

public record CategoryBaseResponse(
    UUID id,
    String name
) {
}