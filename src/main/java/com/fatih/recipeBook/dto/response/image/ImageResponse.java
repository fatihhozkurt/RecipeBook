package com.fatih.recipeBook.dto.response.image;


import java.time.LocalDateTime;
import java.util.UUID;

public record ImageResponse(

    UUID id,
    String filePath,
    LocalDateTime uploadDate,
    String description
) {
}
