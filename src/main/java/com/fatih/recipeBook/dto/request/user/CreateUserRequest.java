package com.fatih.recipeBook.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateUserRequest(

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    String name,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    String surname,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Email(message = "{backend.constraints.Email.message}")
    String email,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Pattern(regexp = "^(\\+90|0)?5\\d{9}$", message = "{backend.constraints.Phone.message}")
    String phone,

    @Min(value = 12, message = "{backend.constraints.Min.message}")
    @Max(value = 100, message = "{backend.constraints.Max.message}")
    Integer age,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=]).*$", message = "{backend.constraints.Password.message}")
    String password
) {
}
