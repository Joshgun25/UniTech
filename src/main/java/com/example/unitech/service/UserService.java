package com.example.unitech.service;

import com.example.unitech.model.User;
import com.example.unitech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String pin) {
        Optional<User> existingUser = userRepository.findByPin(pin);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with this pin already exists");
        }
        User newUser = new User();
        newUser.setPin(pin);
        // Save user to database
        return userRepository.save(newUser);
    }

    public User loginUser(String pin) {
        Optional<User> userOptional = userRepository.findByPin(pin);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        } else {
            throw new IllegalArgumentException("Invalid pin");
        }
    }
}