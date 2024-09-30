package com.fatih.recipeBook.dto.response.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserBaseResponse(

    UUID id,

    String name,

    String surname,

    String email,

    String phone,

    Integer age
) {
}
