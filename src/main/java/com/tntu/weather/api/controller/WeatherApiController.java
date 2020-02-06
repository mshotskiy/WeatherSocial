package com.tntu.weather.api.controller;

import com.tntu.weather.api.dto.WeatherDto;
import com.tntu.weather.api.model.DarkSkyJson;
import com.tntu.weather.api.model.OpenWeatherJson;
import com.tntu.weather.api.model.WeatherBitJson;
import com.tntu.weather.api.service.impl.DarkSkyWeatherApiService;
import com.tntu.weather.api.service.impl.OpenWeatherApiService;
import com.tntu.weather.api.service.impl.WeatherApiServiceImpl;
import com.tntu.weather.api.service.impl.WeatherBitApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherApiController {
    final WeatherApiServiceImpl weatherService;

    public WeatherApiController(WeatherApiServiceImpl weatherService) {
        this.weatherService = weatherService;

    }


    @GetMapping
    public WeatherDto getWeather(){

        return weatherService.getLastWeather();
    }

//    @GetMapping
//    public WeatherDto getWeather(){
//        return weatherService.getLastWeather();
//    }
}
