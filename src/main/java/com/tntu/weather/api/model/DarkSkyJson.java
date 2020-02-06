package com.tntu.weather.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DarkSkyJson implements WeatherCharacteristic {
    private double temperature;



    public DarkSkyJson(double temperature) {
        this.temperature = temperature;
    }



    public void setCurrently(Map<String, String> temperature){
        this.temperature = Double.parseDouble(temperature.get("temperature"));
    }

    @Override
    public String toString() {
        return "DarkSkyJson{" +
                "temperature=" + temperature +
                '}';
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
