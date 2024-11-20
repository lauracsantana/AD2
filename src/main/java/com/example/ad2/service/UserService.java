package com.example.ad2.service;

import com.example.ad2.entity.User;
import com.example.ad2.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to authenticate user credentials
    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return true;  // Password matches
        }
        return false;  // Invalid credentials
    }

    // Method to register new users
    public void register(String email, String password, LocalDate dateOfBirth, String phoneNumber, String aircode) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));  // Hash password with BCrypt
        user.setDateOfBirth(dateOfBirth);
        user.setPhoneNumber(phoneNumber);
        user.setAircode(aircode);
        userRepository.save(user);
    }
}

