package com.api.service.Damains.Weather;

import java.time.LocalDateTime;

import com.api.service.Damains.City.CityModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_city")
    private CityModel city;

    private Integer temp;
    private String date;
    private String description;
    private String currently;
    private Integer humidity;
    private Float rain;
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

    public void EditarDados(CityModel city, WeatherEditarDadosDto dados){
        if(city != null){
            this.city = city;
        }
        if(dados.temp() != null){
            this.temp = dados.temp();
        }
        if(dados.date() != null){
            this.date = dados.date();
        }
        if(dados.description() != null){
            this.description = dados.description();
        }
        if(dados.currently() != null){
            this.currently = dados.currently();
        }
        if(dados.humidity() != null){
            this.humidity = dados.humidity();
        }
        if(dados.rain() != null){
            this.rain = dados.rain();
        }
        if(dados.sunrise() != null){
            this.sunrise = dados.sunrise();
        }
        if(dados.sunset() != null){
            this.sunset = dados.sunset();
        }
        if(dados.moonPhase() != null){
            this.moonPhase = dados.moonPhase();
        }
        
    }
}
