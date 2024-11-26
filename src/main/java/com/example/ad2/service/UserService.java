package com.example.ad2.service;

import com.example.ad2.models.User;
import com.example.ad2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Authenticate the user during login
    public boolean authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    // Register a new user
    public void register(String email, String password, LocalDate dateOfBirth, String phoneNumber, String aircode) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setDateOfBirth(dateOfBirth);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setAircode(aircode);

        userRepository.save(newUser);  // Save the user to the database
    }
}
