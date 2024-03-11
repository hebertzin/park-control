package com.parking.domain.spaces;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record SpacesDTO(
       @NotBlank(message = "title can not be empty") String title,
       @NotBlank(message = "description can not be empty") String description,
       @Positive(message = "price must be a positive number") int price,
       @NotBlank(message = "user id can not be empty") String user
) { }
