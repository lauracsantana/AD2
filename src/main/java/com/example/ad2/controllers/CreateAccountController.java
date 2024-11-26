package com.example.ad2.controllers;

import com.example.ad2.models.User;
import com.example.ad2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/another_day_another_dollar")
public class CreateAccountController {

    @Autowired
    private UserRepository userRepository; // Use the UserRepository to save data

    // Show the create account page
    @GetMapping("/create-account")
    public String showCreateAccountPage() {
        return "createAccount"; // Ensure template name is correct
    }

    // Handle create account form submission
    @PostMapping("/createAccount")
    public String createAccount(@RequestParam String email, 
                                @RequestParam String password,
                                @RequestParam String dateOfBirth, 
                                @RequestParam String phoneNumber,
                                @RequestParam String aircode) {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth); // Parse date
            // Create new user object and set properties
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setDateOfBirth(dob);
            user.setPhoneNumber(phoneNumber);
            user.setAircode(aircode);

            // Save user to the database
            userRepository.save(user);

            // Redirect to login page after successful registration
            return "redirect:/another_day_another_dollar/login";
        } catch (Exception e) {
            // Log the error and return to the create account page
            return "createAccount";
        }
    }
}
