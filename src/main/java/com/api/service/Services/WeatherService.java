package com.api.service.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<WeatherModel> weatherAnteriores(Long id, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable){
        if (startDate != null && endDate != null) {
            return weatherRepository.findAllByCityIdAndCreateAtBetween(id, startDate, endDate, pageable);
        } else if (startDate != null) {
            LocalDateTime now = LocalDateTime.now();
            return weatherRepository.findAllByCityIdAndCreateAtBetween(id, startDate, now, pageable);
        } else if (endDate != null) {
            LocalDateTime startDateTime = LocalDateTime.parse("1900-01-01T00:00:00");
            return weatherRepository.findAllByCityIdAndCreateAtBetween(id, startDateTime, endDate, pageable);
        } else {
            return weatherRepository.findAllByCityId(id, pageable);
        }
    }

    public WeatherExibirDadosDto ultimaAtualizacao(Long id){
        List<WeatherModel> weatherList = weatherRepository.findByCityIdOrderByCreateAtDesc(id);
        
        if(!weatherList.isEmpty()){
            WeatherModel weather = weatherList.get(0);
            return new WeatherExibirDadosDto(weather);
        }else{
            throw new ValidationException("Não foi encontrados dados da cidade informada!");
        }
    }
}
