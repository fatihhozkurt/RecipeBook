package com.fatih.recipeBook.dto.response.user;

import java.util.UUID;

public record UserCommentResponse(

    UUID uuid,
    String name,
    String surname

) {
}
