package com.api.service.Damains.City;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "city")
@Entity
@Getter
@Setter
public class CityModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime creataAt;

    public CityModel(CityDto dados){
        this.name = dados.name();
        this.creataAt = LocalDateTime.now();
    }
}
