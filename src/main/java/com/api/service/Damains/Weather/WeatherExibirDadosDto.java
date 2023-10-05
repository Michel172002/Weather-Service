package com.api.service.Damains.Weather;

import java.time.LocalDateTime;

import com.api.service.Damains.City.CityExibirDadosDto;

public record WeatherExibirDadosDto(
    Long id,
    CityExibirDadosDto city,
    Integer temp,
    String date,
    String description,
    String currently,
    Integer humidity,
    Float rain,
    String sunrise,
    String sunset,
    String moonPhase,
    LocalDateTime createAt

) {
    public WeatherExibirDadosDto(WeatherModel dados){
        this(dados.getId(), new CityExibirDadosDto(dados.getCity()),dados.getTemp(), dados.getDate(), dados.getDescription(), dados.getCurrently(),
         dados.getHumidity(), dados.getRain(), dados.getSunrise(), dados.getSunset(), dados.getMoonPhase(), dados.getCreateAt());
    }
}
