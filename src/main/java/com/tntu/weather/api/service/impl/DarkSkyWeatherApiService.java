package com.tntu.weather.api.service.impl;

import com.tntu.weather.api.model.DarkSkyJson;
import com.tntu.weather.api.service.ApiService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class DarkSkyWeatherApiService implements ApiService {
    private Environment env;
    private RestTemplate restTemplate;

    public DarkSkyWeatherApiService(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    public DarkSkyJson getWeather() {
        return restTemplate.getForObject(getUri(), DarkSkyJson.class);
    }

    private String getUri() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(Objects.requireNonNull(env.getProperty("darksky.api.url")))
                .pathSegment(env.getProperty("darksky.api.request"))
                .pathSegment(env.getProperty("darksky.api.key"))
                .pathSegment(env.getProperty("city.Ternopil.lat") + "," + env.getProperty("city.Ternopil.lon"))
                .queryParam("units", env.getProperty("darksky.api.units"))
                .queryParam("exclude", env.getProperty("darksky.api.exclude"));
        return uriBuilder.toUriString();
    }


}
