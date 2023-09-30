package com.api.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.service.Damains.WeatherDto;
import com.api.service.Damains.WeatherExibirDadosDto;
import com.api.service.Damains.WeatherModel;
import com.api.service.Repositories.WeatherRepository;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherExibirDadosDto criarWeather(WeatherDto weatherDto){
        var weather = new WeatherModel(weatherDto);
        weatherRepository.save(weather);

        return new WeatherExibirDadosDto(weather);
    }

}
