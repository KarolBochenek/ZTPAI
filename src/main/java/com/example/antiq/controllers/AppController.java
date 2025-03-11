package com.example.antiq.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController{
    @GetMapping("/")
    public String hello()
    {
        return "hello world";
    }
}