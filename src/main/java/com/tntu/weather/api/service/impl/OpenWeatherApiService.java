package com.tntu.weather.api.service.impl;

import com.tntu.weather.api.model.OpenWeatherJson;
import com.tntu.weather.api.service.ApiService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class OpenWeatherApiService implements ApiService {
    private final RestTemplate restTemplate;
    private Environment env;

    public OpenWeatherApiService(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    public OpenWeatherJson getWeather() {
        return restTemplate.getForObject(getUri(), OpenWeatherJson.class);
    }


    private String getUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(Objects.requireNonNull(env.getProperty("openweather.api.url")))
                .queryParam("lat", env.getProperty("city.Ternopil.lat"))
                .queryParam("lon", env.getProperty("city.Ternopil.lon"))
                .queryParam("APPID", env.getProperty("openweather.api.key"))
                .queryParam("units", env.getProperty("openweather.api.unit"));

        return uriBuilder.toUriString();
    }

}
