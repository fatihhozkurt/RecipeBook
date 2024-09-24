package com.fatih.recipeBook.dto.request.recipe;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RecipeRequest(

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Size(min = 2, max = 30, message = "{backend.constraints.Size.message}")
    String name,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Size(min = 20, max = 500, message = "{backend.constraints.Size.message}")
    String description,

    @Min(value = 2, message = "backend.constraints.Min.message")
    @Max(value = 60, message = "{backend.constraints.Max.message}")
    Integer readingTime
) {
}
