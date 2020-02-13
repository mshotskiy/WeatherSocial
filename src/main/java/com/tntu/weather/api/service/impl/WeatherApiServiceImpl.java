package com.tntu.weather.api.service.impl;


import com.tntu.weather.api.dto.WeatherDto;
import com.tntu.weather.api.entity.WeatherApi;
import com.tntu.weather.api.model.WeatherCharacteristic;
import com.tntu.weather.api.repository.WeatherApiRepository;
import com.tntu.weather.api.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class WeatherApiServiceImpl implements WeatherService {

    private WeatherApiRepository apiRepository;
    private OpenWeatherApiService openWeatherApiService;
    private DarkSkyWeatherApiService darkSkyWeatherApiService;
    private WeatherBitApiService weatherBitApiService;

    public WeatherApiServiceImpl(OpenWeatherApiService openWeatherApiService,
                                 DarkSkyWeatherApiService darkSkyWeatherApiService,
                                 WeatherBitApiService weatherBitApiService,
                                 WeatherApiRepository weatherApiRepository) {

        this.apiRepository = weatherApiRepository;
        this.openWeatherApiService = openWeatherApiService;
        this.darkSkyWeatherApiService = darkSkyWeatherApiService;
        this.weatherBitApiService = weatherBitApiService;
    }

    @Scheduled(fixedRate = 1000 * 60)
    private void getWeatherFromApi() {
        WeatherApi weatherApi = new WeatherApi();
        List<WeatherCharacteristic> apiServices = getApiServices();

        int temp = getAvg(apiServices.get(0).getTemperature(), apiServices.get(1).getTemperature(),
                apiServices.get(2).getTemperature());
        weatherApi.setTemperature(temp);
        apiRepository.save(weatherApi);
    }

    public WeatherDto getLastWeather() {
        final Iterator<WeatherApi> weatherIterable = apiRepository.findAll().iterator();
        WeatherApi weather = weatherIterable.next();

        while (weatherIterable.hasNext()) {
            weather = weatherIterable.next();
        }
        return new WeatherDto(weather);
    }


    private int getAvg(double... arrDouble) {
        double sum = 0;
        int length = arrDouble.length;
        for (double v : arrDouble) {
            sum += v;
        }
        return (int) sum / length;
    }

    private List<WeatherCharacteristic> getApiServices() {
        List<WeatherCharacteristic> apiServices = new ArrayList<>();

        apiServices.add(openWeatherApiService.getWeather());
        apiServices.add(darkSkyWeatherApiService.getWeather());
        apiServices.add(weatherBitApiService.getWeather());

        return apiServices;
    }
}
