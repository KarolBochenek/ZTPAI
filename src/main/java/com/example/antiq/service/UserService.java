package com.example.antiq.service;

import com.example.antiq.entity.Email;
import com.example.antiq.entity.User;
import com.example.antiq.repository.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    static final String emailExchange = "antiq_email_exchange";

    static final String emailRoutingKey = "antiq_email_key";


    public void createUser(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .enabled(true)
                .build();
        userRepository.save(user);
        sendEmail(user, "Email Verification");
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
    private void sendEmail(User user, String subject) {
        Map<String, Object> mailData = Map.of( "fullName", user.getUsername());
        logger.info("Sending email to: " + user.getEmail() + " with subject: " + subject);
        logger.info("Email content: " + mailData);
        try {
            rabbitTemplate.convertAndSend(emailExchange, emailRoutingKey, Email.builder()
                    .to(user.getEmail())
                    .subject(subject)
                    .dynamicValue(mailData)
                    .templateName("verification")
                    .build());
            logger.info("Email successfully sent to: {}", user.getEmail());
        }
        catch (Exception e) {
            logger.error("Error sending email to: {}. Error: {}", user.getEmail(), e.getMessage());
        }
    }
}
