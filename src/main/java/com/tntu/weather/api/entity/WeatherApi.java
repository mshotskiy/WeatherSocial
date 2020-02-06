package com.tntu.weather.api.entity;

import com.tntu.weather.api.dto.WeatherDto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class WeatherApi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int temperature;
    private String city;


    public WeatherApi() {
    }


    public WeatherApi(int temperature, String city) {
        this.temperature = temperature;
        this.city = city;
    }

    public WeatherApi(WeatherDto weatherDto){
        this.temperature = weatherDto.getTemperature();
        this.city = weatherDto.getCity();
    }

    public long getId() {
        return id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "WeatherApi{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", city='" + city + '\'' +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }
}