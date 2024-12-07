package com.example.antiq.controllers;

@RestController
public class AppController{
    @GetMapping
    public String hello()
    {
        return "hello world";
    }
}