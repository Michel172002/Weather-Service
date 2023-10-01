package com.api.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.service.Damains.City.CityDto;
import com.api.service.Damains.City.CityExibirDadosDto;
import com.api.service.Damains.City.CityModel;
import com.api.service.Repositories.CityRepository;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityExibirDadosDto criarCity(CityDto dados){
        var city = new CityModel(dados);
        cityRepository.save(city);

        return new CityExibirDadosDto(city);
    }
}
