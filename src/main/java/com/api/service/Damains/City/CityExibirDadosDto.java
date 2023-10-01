package com.api.service.Damains.City;

import java.time.LocalDateTime;

public record CityExibirDadosDto(
    Long id,
    String name,
    LocalDateTime createAt
) {
    public CityExibirDadosDto(CityModel dados){
        this(dados.getId(), dados.getName(), dados.getCreataAt());
    }
}
