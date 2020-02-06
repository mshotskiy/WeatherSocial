package com.tntu.weather.api.service;


import com.tntu.weather.api.entity.WeatherApi;
import com.tntu.weather.api.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getLastWeather();


}
