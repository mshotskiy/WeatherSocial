package com.tntu.controller;


import com.tntu.entity.Message;
import com.tntu.entity.User;
import com.tntu.service.MessageService;
import com.tntu.service.WeatherService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class WeatherController {

    private final WeatherService weatherService;
    private final MessageService messageService;


    public WeatherController(WeatherService weatherService, MessageService messageService) {
        this.weatherService = weatherService;

        this.messageService = messageService;
    }


    @GetMapping("/")
    public String index(Map<String, Object> model){
        try {
            model.put("weather", weatherService.getWeatherFromApi());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/home")
    public String userPage(Map<String, Object> model) throws IOException {
        model.put("weathers", weatherService.getWeatherFromApi());
        model.put("messages",messageService.getAllMessages());
        return "userPage";
    }

//    @PostMapping("/message")
//    public String addMessage(
//            @AuthenticationPrincipal User user,
//            @RequestParam String text,
//            @RequestParam String tag,
//            Map<String, Object> model) throws IOException {
//        messageService.addMessage(new Message(text, tag, user.getUsername()));
//        model.put("weathers", weatherService.getWeatherFromApi());
//        model.put("messages",messageService.getAllMessages());
//        return "userPage";
//    }


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
