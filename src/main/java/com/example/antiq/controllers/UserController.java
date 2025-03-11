package com.example.antiq.controllers;

import com.example.antiq.service.UserService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String firstname,
                               @RequestParam String lastname,
                               @RequestParam String email,
                               @RequestParam String password) {
        userService.createUser(firstname, lastname, email, password);
        return "User registered successfully!";
    }
}
