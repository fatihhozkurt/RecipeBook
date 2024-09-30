package com.fatih.recipeBook.dto.request.user;

import java.util.Optional;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateUserRequest(

    @Size(min = 2, max = 20, message = "{backend.constraints.Size.message}")
    String name,

    @Size(min = 2, max = 20, message = "{backend.constraints.Size.message}")
    String surname,

    @Email(message = "{backend.constraints.Email.message}")
    @Size(min = 13, max = 60, message = "{backend.constraints.Size.message}")
    String email,

    @Pattern(regexp = "^(\\+90|0)?5\\d{9}$", message = "{backend.constraints.Phone.message}")
    String phone,

    @Min(value = 12, message = "{backend.constraints.Min.message}")
    @Max(value = 100, message = "{backend.constraints.Max.message}")
    Integer age,

    @Pattern(regexp = "^(?=.*[A-ZÇĞİÖŞÜ])(?=.*[a-zçğıöşü])(?=.*[0-9]).*$", message = "{backend.constraints.Password.message}")
    @Size(min = 8, max = 16, message = "{backend.constraints.Size.message}")
    String password
) {
}