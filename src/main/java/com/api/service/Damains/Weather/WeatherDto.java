package com.api.service.Damains.Weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WeatherDto(
    @NotNull
    Long idCity,

    @NotNull
    Integer temp,

    @NotBlank
    String date,

    @NotBlank
    String description,

    @NotBlank
    String currently,

    @NotNull
    Integer humidity,

    @NotNull
    float rain,

    @NotBlank
    String sunrise,

    @NotBlank
    String sunset,

    @NotBlank
    @JsonProperty("moon_phase")
    String moonPhase
) {
    
}
