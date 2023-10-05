package com.api.service.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.service.Damains.City.CityDto;
import com.api.service.Damains.City.CityEditarDados;
import com.api.service.Damains.City.CityExibirDadosDto;
import com.api.service.Damains.City.CityModel;
import com.api.service.Repositories.CityRepository;

import jakarta.validation.ValidationException;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityExibirDadosDto criarCity(CityDto dados){
        var city = new CityModel(dados);
        cityRepository.save(city);

        return new CityExibirDadosDto(city);
    }

    public Page<CityModel> exibirCity(Pageable pageable){
        return cityRepository.findAll(pageable);
    }

    public CityExibirDadosDto editarCity(Long id, CityEditarDados dados){
        if(!cityRepository.existsById(id)){
            throw new ValidationException("Não existe City com o id informado!");
        }
        var city = cityRepository.getReferenceById(id);
        city.EditarDados(dados);

        return new CityExibirDadosDto(city);
    }

    public CityExibirDadosDto excluirCity(Long id){
        if(!cityRepository.existsById(id)){
            throw new ValidationException("Não existe City com o id informado!");
        }
        var city = cityRepository.getReferenceById(id);
        cityRepository.delete(city);

        return new CityExibirDadosDto(city);
    }
}
