package com.api.service.Damains.Weather;

public record WeatherEditarDadosDto(
        Long idCity,
        Integer temp,
        String date,
        String description,
        String currently,
        Integer humidity,
        Float rain,
        String sunrise,
        String sunset,
        String moonPhase
) {
    
}
