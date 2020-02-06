package com.tntu.controller;


import com.tntu.entity.User;
import com.tntu.service.WeatherService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/")
    public String index(Map<String, Object> model){
        model.put("weather", weatherService.getWeatherFromApi());
        return "index";
    }

    @GetMapping("/weather")
    public String userPage(Map<String, Object> model){
        model.put("weathers", weatherService.getWeatherFromApi());
        return "userPage";
    }

//    @PostMapping("/weather")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @RequestParam String add,
//            Map<String, Object> model){
//        if (add.equals("1")) {
//            weatherService.addWeatherFromApi(user);
//            Iterable<Weather> weathers = weatherService.findByThisUser(user);
//            model.put("weathers", weathers);
//
//        }
//        return "userPage";
//    }


}
