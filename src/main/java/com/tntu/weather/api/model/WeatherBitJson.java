package com.tntu.weather.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherBitJson implements WeatherCharacteristic{
    private double temperature;

    @Override
    public String toString() {
        return "WeatherBitJson{" +
                "temperature=" + temperature +
                '}';
    }

    public void setData(Map<String, Object>[] data){
        this.temperature = Double.parseDouble(data[0].get("temp").toString());
    }

    @Override
    public double getTemperature() {
        return temperature;
    }
}
