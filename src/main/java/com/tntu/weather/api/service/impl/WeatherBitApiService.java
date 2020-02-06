package com.tntu.weather.api.service.impl;

import com.tntu.weather.api.model.WeatherBitJson;
import com.tntu.weather.api.service.ApiService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class WeatherBitApiService implements ApiService {
    private Environment env;
    private RestTemplate restTemplate;

    public WeatherBitApiService(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    public WeatherBitJson getWeather() {
        return restTemplate.getForObject(getUri(), WeatherBitJson.class);
    }

    private String getUri(){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(Objects.requireNonNull(env.getProperty("weatherbit.api.url")))
                .queryParam("lat", env.getProperty("city.Ternopil.lat"))
                .queryParam("lon", env.getProperty("city.Ternopil.lon"))
                .queryParam("key", env.getProperty("weatherbit.api.key"));
        return uriBuilder.toUriString();
    }
}
