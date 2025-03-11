package com.example.antiq.controllers;

import com.example.antiq.entity.User;
import com.example.antiq.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@Tag(name = "User management", description = "APIs for user management")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get all users", description = "Fetch a list of all users in the system")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Get user by ID", description = "Fetch a specific user by their ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @Operation(summary = "Update user", description = "Update an existing user's details")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @Operation(summary = "Delete user", description = "Remove a user from the system by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
