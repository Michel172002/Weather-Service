package com.api.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.service.Damains.WeatherModel;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherModel, Long>{
    
}