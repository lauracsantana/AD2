package com.example.ad2.controllers;

import com.example.ad2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping (path="/another_day_another_dollar") //this means url's start with /demo after application path
public class LoginController {

    @Autowired
    private UserService userService;

    // Show the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // This will map to src/main/resources/templates/login.html
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isAuthenticated = userService.authenticate(email, password);
        if (isAuthenticated) {
            return "redirect:/dashboard";  // Redirect to a dashboard after successful login
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "login";  // Return to login page with error message
        }
    }

    // Show the registration page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";  // This will map to the registration page (create this template)
    }

    // Handle registration form submission
    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, 
                           @RequestParam String dateOfBirth, @RequestParam String phoneNumber, 
                           @RequestParam String aircode, Model model) {
        try {
            LocalDate dob = LocalDate.parse(dateOfBirth); // Parse the date string into LocalDate
            userService.register(email, password, dob, phoneNumber, aircode);
            return "redirect:/login";  // Redirect to login after successful registration
        } catch (Exception e) {
            model.addAttribute("error", "Invalid input, please check your data.");
            return "register";  // Return to registration page if error occurs
        }
    }
}

