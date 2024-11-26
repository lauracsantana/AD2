package com.example.ad2.controllers;

import com.example.ad2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/another_day_another_dollar")
public class LoginController {

    @Autowired
    private UserService userService;

    // Show the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Maps to src/main/resources/templates/login.html
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        boolean isAuthenticated = userService.authenticate(email, password);
        if (isAuthenticated) {
            return "redirect:/another_day_another_dollar/homePage";  // Redirect to home page after successful login
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "login";  // Return to login page with error message
        }
    }

}
