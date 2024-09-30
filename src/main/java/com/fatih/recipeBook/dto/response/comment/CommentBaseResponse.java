package com.fatih.recipeBook.dto.response.comment;

import java.util.UUID;

public record CommentBaseResponse(

    UUID uuid,
    String title,
    String detail,
    UUID userID,
    UUID commentID


) {
}
