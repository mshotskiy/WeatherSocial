package com.tntu.weather.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherJson implements WeatherCharacteristic{
    private double temperature;
    private String name;

    public OpenWeatherJson() {
    }


    public void setMain(Map<String, String> main) {
        this.temperature = Double.parseDouble(main.get("temp"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "WeatherInfo{" +
                "temperature=" + temperature +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
