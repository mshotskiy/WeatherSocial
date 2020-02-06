package com.tntu.controller;


import com.tntu.entity.User;
import com.tntu.exceptions.CreateUserException;
import com.tntu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        try {
            userService.createUser(user);
        }catch (CreateUserException ex){
            return "redirect:/login";
        }
        return "weather";
    }
}