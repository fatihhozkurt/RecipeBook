package com.fatih.recipeBook.dto.request.image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImageRequest(

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    String filePath,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    String description

) {
}
