package com.fatih.recipeBook.dto.response.user;

import java.time.LocalDateTime;

public record UserUpdateResponse(

    LocalDateTime updateTime,

    String name,

    String surname,

    String email,

    String phone,

    Integer age
) {
}
