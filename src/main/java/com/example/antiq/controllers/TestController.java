package com.example.antiq.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Authorization for content tests", description = "APIs for authorization tests")
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Operation(summary = "Test access for all", description = "Content visible for anyone")
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }
    @Operation(summary = "Test access for authorized user", description = "Content visible for authorized users")
    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }
}
