package com.fatih.recipeBook.dto.response.comment;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fatih.recipeBook.dto.response.user.UserCommentResponse;

public record CommentPageResponse(

    LocalDateTime createTime,
    UUID uuid,
    String title,
    String detail,
    UserCommentResponse userCommentResponse
) {
}
