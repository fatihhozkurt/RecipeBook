package com.fatih.recipeBook.dto.response.user;

import java.util.UUID;

public record UserCardResponse(
    UUID id,
    String name,
    String surname,
    String email,
    String phone
) {
}
