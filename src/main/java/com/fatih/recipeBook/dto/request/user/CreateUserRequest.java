package com.fatih.recipeBook.dto.request.user;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Size(min = 2, max = 20, message = "{backend.constraints.Size.message}")
    String name,

    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Size(min = 2, max = 20, message = "{backend.constraints.Size.message}")
    String surname,


    @NotNull(message = "{backend.constraints.NotNull.message}")
    @NotBlank(message = "{backend.constraints.NotBlank.message}")
    @Email(message = "{backend.constraints.Email.message}")
    @Size(min = 13, max = 60, message = "{backend.constraints.Size.message}")
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
    @Pattern(regexp = "^(?=.*[A-ZÇĞİÖŞÜ])(?=.*[a-zçğıöşü])(?=.*[0-9]).*$", message = "{backend.constraints.Password.message}")
    @Size(min = 8, max = 16, message = "{backend.constraints.Size.message}")
    String password
) {
}
