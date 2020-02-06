package com.tntu.weather.api.repository;

import com.tntu.weather.api.entity.WeatherApi;
import org.springframework.data.repository.CrudRepository;

public interface WeatherApiRepository extends CrudRepository<WeatherApi, Integer> {
}
