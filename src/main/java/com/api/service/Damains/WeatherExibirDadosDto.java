package com.api.service.Damains;

import java.time.LocalDateTime;

public record WeatherExibirDadosDto(
    Long id,
    int temp,
    String date,
    String description,
    String currently,
    String city,
    int humidity,
    float rain,
    String sunrise,
    String sunset,
    String moonPhase,
    LocalDateTime createAt

) {
    public WeatherExibirDadosDto(WeatherModel dados){
        this(dados.getId(), dados.getTemp(), dados.getDate(), dados.getDescription(), dados.getCurrently(), dados.getCity(),
         dados.getHumidity(), dados.getRain(), dados.getSunrise(), dados.getSunset(), dados.getMoonPhase(), dados.getCreateAt());
    }
}
