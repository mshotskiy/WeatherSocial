package com.tntu.service;


import com.tntu.model.Weather;

import java.io.IOException;

public interface WeatherService {
    Weather getWeatherFromApi() throws IOException;

}
