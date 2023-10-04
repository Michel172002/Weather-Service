package com.api.service.Controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.Damains.Weather.WeatherDto;
import com.api.service.Damains.Weather.WeatherExibirDadosDto;
import com.api.service.Damains.Weather.WeatherModel;
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

    @GetMapping("/{id}/anteriores")
    public ResponseEntity<Page<WeatherModel>> weatherAnteriores(
        @PathVariable(value = "id") Long id,
        @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
        @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
        @PageableDefault(size = 4, sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable)
    {
        Page<WeatherModel> weatherPage = weatherService.weatherAnteriores(id, startDate, endDate, pageable);
        
        return ResponseEntity.status(HttpStatus.OK).body(weatherPage); 
    }

    @GetMapping("/{id}/atualizado")
    public ResponseEntity<WeatherExibirDadosDto> weatherAtualizado(@PathVariable(value = "id") Long id){
        var weatherAtualizado = weatherService.ultimaAtualizacao(id);

        return ResponseEntity.status(HttpStatus.OK).body(weatherAtualizado);
    }
}
