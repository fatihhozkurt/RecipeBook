package com.fatih.recipeBook.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    String name
) {
}
