package com.fatih.recipeBook.dto.response.user;

import java.util.UUID;

public record UserPageResponse(

    UUID uuid,
    String name,
    String surname,
    String email,
    String phone
) {
}
