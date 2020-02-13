package com.tntu.service.impl;


import com.tntu.model.Weather;

import com.tntu.service.WeatherService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

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
    public Weather getWeatherFromApi() throws IOException {
        return getWeather();
    }


    private Weather getWeather() throws IOException {
        return Optional.ofNullable(restTemplate.getForObject(getUri(), Weather.class)).orElseThrow(IOException::new);
    }


    private String getUri() {
        return env.getProperty("external.api.url");
    }

}
