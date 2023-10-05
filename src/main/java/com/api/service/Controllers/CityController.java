package com.api.service.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.Damains.City.CityDto;
import com.api.service.Damains.City.CityEditarDados;
import com.api.service.Damains.City.CityExibirDadosDto;
import com.api.service.Damains.City.CityModel;
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

    @GetMapping
    public ResponseEntity<Page<CityModel>> exibirCity(Pageable pageable){
        var cityPage = cityService.exibirCity(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(cityPage);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CityExibirDadosDto> editarCity(@PathVariable(value = "id")Long id, @RequestBody CityEditarDados dados){
        var cityEditado = cityService.editarCity(id, dados);

        return ResponseEntity.status(HttpStatus.OK).body(cityEditado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<CityExibirDadosDto> excluirCity(@PathVariable(value = "id")Long id){
        var cityExcluida = cityService.excluirCity(id);

        return ResponseEntity.status(HttpStatus.OK).body(cityExcluida);
    }
}

