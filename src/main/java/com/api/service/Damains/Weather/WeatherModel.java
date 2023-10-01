package com.api.service.Damains.Weather;

import java.time.LocalDateTime;

import com.api.service.Damains.City.CityModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "weather")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class WeatherModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city")
    private CityModel city;

    private int temp;
    private String date;
    private String description;
    private String currently;
    private int humidity;
    private float rain;
    private String sunrise;
    private String sunset;
    private String moonPhase;
    private LocalDateTime createAt;

    public WeatherModel(WeatherDto dados, CityModel city){
        this.city = city;

        this.temp = dados.temp();
        this.date = dados.date();
        this.description = dados.description();
        this.currently = dados.currently();
        this.humidity = dados.humidity();
        this.rain = dados.rain();
        this.sunrise = dados.sunrise();
        this.sunset = dados.sunset();
        this.moonPhase = dados.moonPhase();
        this.createAt = LocalDateTime.now();
    }
}
