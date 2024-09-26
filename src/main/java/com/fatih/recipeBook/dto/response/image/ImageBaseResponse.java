package com.fatih.recipeBook.dto.response.image;

import java.time.LocalDateTime;
import java.util.UUID;

public record ImageBaseResponse(
    UUID id,
    String fileName,
    String fileType,
    LocalDateTime createTime,
    byte[] data
){
}
