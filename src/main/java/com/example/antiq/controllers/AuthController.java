package com.example.antiq.controllers;

import com.example.antiq.entity.User;
import com.example.antiq.repository.UserRepository;
import com.example.antiq.security.JWTUtil;
import com.example.antiq.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Authorization Management", description = "APIs for authorization")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private final UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JWTUtil jwtUtils;
    @Operation(summary = "Log in", description = "Log in with email and password")
    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
    @Operation(summary = "Register", description = "Register with email and password")
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userService.checkIfEmailExists(user.getUsername())) {
            return "Email is already in use!";
        }

        userService.createUser(user.getUsername(), user.getPassword());
        return "User registered successfully!";
    }
}
