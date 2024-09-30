package com.fatih.recipeBook.dto.request.comment;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCommentRequest(

    @NotNull
    @NotBlank
    @Size(min = 4, max = 25, message = "{backend.constraints.Size.message}")
    String title,

    @NotNull
    @NotBlank
    String detail,

    @NotNull
    @NotBlank
    UUID recipeID,

    @NotNull
    @NotBlank
    UUID userID
) {
}
