package com.fatih.recipeBook.dto.response.user;

import java.util.UUID;

public record UserResponse(

    UUID id,
    String name,
    String surname,
    String email,
    String phone,
    Integer age
) {
}