package com.tntu.service.impl;


import com.tntu.model.Weather;

import com.tntu.service.WeatherService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
@Service
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate;
    private Environment env;


    public WeatherServiceImpl(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    @Override
    public Weather getWeatherFromApi() {
        return getWeather();
    }


    private Weather getWeather() {
        return restTemplate.getForObject(getUri(), Weather.class);
    }


    private String getUri() {
        return env.getProperty("external.api.url");
    }

}
