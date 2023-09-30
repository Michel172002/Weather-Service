package com.api.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.Damains.WeatherDto;
import com.api.service.Damains.WeatherExibirDadosDto;
import com.api.service.Services.WeatherService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @PostMapping
    @Transactional
    public ResponseEntity<WeatherExibirDadosDto> criarWeather(@Valid @RequestBody WeatherDto weatherDto){
        var createWeather = weatherService.criarWeather(weatherDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createWeather);
    }
}
