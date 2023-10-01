package com.api.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.service.Damains.City.CityModel;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long>{
    
}
