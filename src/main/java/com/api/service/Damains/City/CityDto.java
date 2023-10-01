package com.api.service.Damains.City;

import jakarta.validation.constraints.NotBlank;

public record CityDto(
    @NotBlank
    String name
) {
    
}
