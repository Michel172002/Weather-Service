package com.api.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.service.Damains.Weather.WeatherDto;
import com.api.service.Damains.Weather.WeatherExibirDadosDto;
import com.api.service.Damains.Weather.WeatherModel;
import com.api.service.Repositories.CityRepository;
import com.api.service.Repositories.WeatherRepository;

import jakarta.validation.ValidationException;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private CityRepository cityRepository;

    public WeatherExibirDadosDto criarWeather(WeatherDto weatherDto){
        if(!cityRepository.existsById(weatherDto.idCity())){
            throw new ValidationException("Não existe cidade com o id informado!");
        }
        var city = cityRepository.getReferenceById(weatherDto.idCity());
        var weather = new WeatherModel(weatherDto, city);
        weatherRepository.save(weather);    

        return new WeatherExibirDadosDto(weather);
    }

}
