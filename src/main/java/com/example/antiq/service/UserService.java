package com.example.antiq.service;

import com.example.antiq.entity.User;
import com.example.antiq.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .build();
        userRepository.save(user);
    }
    public boolean checkIfEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public User updateUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
