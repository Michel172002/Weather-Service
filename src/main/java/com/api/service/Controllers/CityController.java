package com.api.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.Damains.City.CityDto;
import com.api.service.Damains.City.CityExibirDadosDto;
import com.api.service.Services.CityService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    @Transactional
    public ResponseEntity<CityExibirDadosDto> criarCity(@Valid @RequestBody CityDto dados){
        var createdCity = cityService.criarCity(dados);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }
}