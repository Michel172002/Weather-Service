package com.api.service.Damains.Weather;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "weather")
@Entity
@Getter
@Setter
public class WeatherModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int temp;
    private String date;
    private String description;
    private String currently;
    private String city;
    private int humidity;
    private float rain;
    private String sunrise;
    private String sunset;
    private String moonPhase;
    private LocalDateTime createAt;

    public WeatherModel(WeatherDto dados){
        this.temp = dados.temp();
        this.date = dados.date();
        this.description = dados.description();
        this.currently = dados.currently();
        this.city = dados.city();
        this.humidity = dados.humidity();
        this.rain = dados.rain();
        this.sunrise = dados.sunrise();
        this.sunset = dados.sunset();
        this.moonPhase = dados.moonPhase();
        this.createAt = LocalDateTime.now();
    }
}
