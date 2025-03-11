package com.example.antiq.controllers;

import com.example.antiq.entity.User;
import com.example.antiq.repository.UserRepository;
import com.example.antiq.security.JWTUtil;
import com.example.antiq.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userService.checkIfEmailExists(user.getUsername())) {
            return "Email is already in use!";
        }

        userService.createUser(user.getUsername(), user.getPassword());
        return "User registered successfully!";
    }
}
