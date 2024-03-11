package com.parking.domain.vehicle;

import jakarta.validation.constraints.NotBlank;

public record VehicleDTO(
        @NotBlank(message = "brand can not be empty")
        String brand,
        @NotBlank(message = "model can not be empty")
        String model,
        @NotBlank(message = "plate can not be empty")
        String plate ,
        @NotBlank(message = "userId can not be empty")
        String userId) {}
