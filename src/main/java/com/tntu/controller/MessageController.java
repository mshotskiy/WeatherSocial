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
public class MessageController {

    private final MessageService messageService;
    private final WeatherService weatherService;

    public MessageController(MessageService messageService, WeatherService weatherService) {
        this.messageService = messageService;
        this.weatherService = weatherService;
    }


    @PostMapping("/message")
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) throws IOException {
        messageService.addMessage(new Message(text, tag, user.getUsername()));
        model.put("weathers", weatherService.getWeatherFromApi());
        model.put("messages", messageService.getAllMessages());
        return "userPage";
    }

    @PostMapping("/delete")
    public String deleteMessage(
            @RequestParam Long id,
            @AuthenticationPrincipal User user,
            Map<String, Object> model) throws IOException {

        messageService.deleteMessage(id, user);

        model.put("weathers", weatherService.getWeatherFromApi());
        model.put("messages", messageService.getAllMessages());
        return "redirect:/home";
    }

    @GetMapping("/update")
    public String update( Map<String, Object> model) throws IOException {
        model.put("visible", "true");
        model.put("weathers", weatherService.getWeatherFromApi());
        model.put("messages", messageService.getAllMessages());
        return "userPage";
    }


    @PostMapping("/update")
    public String updateMessage(
            @RequestParam Long messageId,
            @RequestParam String text,
            @AuthenticationPrincipal User user,
            Map<String, Object> model) throws IOException {

        messageService.updateMessage(messageId, text, user);

        model.put("weathers", weatherService.getWeatherFromApi());
        model.put("messages", messageService.getAllMessages());
        return "userPage";
    }
}
