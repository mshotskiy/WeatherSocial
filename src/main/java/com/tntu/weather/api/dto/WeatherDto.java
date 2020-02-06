package com.tntu.weather.api.dto;


import com.tntu.weather.api.entity.WeatherApi;

public class WeatherDto {
    private long id;

    private int temperature;
    private String city;

    public WeatherDto(WeatherApi weather) {
        this.id = weather.getId();
        this.temperature = weather.getTemperature();
        this.city = weather.getCity();
    }

    public WeatherDto(long id, int temperature, String city) {
        this.id = id;
        this.temperature = temperature;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCity(String city) {
        this.city = city;
    }

}
