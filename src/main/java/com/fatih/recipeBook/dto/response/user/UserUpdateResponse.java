package com.fatih.recipeBook.dto.response.user;

public record UserUpdateResponse(

    String name,

    String surname,

    String email,

    String phone,

    Integer age,

    String password

) {
}
