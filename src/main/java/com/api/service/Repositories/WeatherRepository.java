package com.api.service.Repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.service.Damains.Weather.WeatherModel;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherModel, Long>{
    Page<WeatherModel> findAllByCityId(Long id, Pageable pageable);

    Page<WeatherModel> findAllByCityIdAndCreateAtBetween(
        Long id,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Pageable pageable
    );

    List<WeatherModel> findByCityIdOrderByCreateAtDesc(Long id);
}