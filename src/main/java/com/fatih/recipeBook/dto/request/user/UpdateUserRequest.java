package com.fatih.recipeBook.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public record UpdateUserRequest(
    String name,

    String surname,

    @Email(message = "{backend.constraints.Email.message}")
    String email,

    @Pattern(regexp = "^(\\+90|0)?5\\d{9}$", message = "{backend.constraints.Phone.message}")
    String phone,

    @Min(value = 12, message = "{backend.constraints.Min.message}")
    @Max(value = 100, message = "{backend.constraints.Max.message}")
    Integer age,

    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$", message = "{backend.constraints.Password.message}")
    String password

) {
}
