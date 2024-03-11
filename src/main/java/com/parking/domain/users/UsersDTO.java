package com.parking.domain.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsersDTO(
        @NotBlank(message = "name can not be empty") String name,
        @NotBlank(message = "name can not be empty")
        @Email(message = "must be a valid email")
        String email,
        @NotBlank(message = "password can not be empty")
        @Pattern(regexp = "^.{6,}$", message = "at least 6 characters")
        String password)
{}
