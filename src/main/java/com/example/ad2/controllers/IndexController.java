package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/another_day_another_dollar")  
public class IndexController {

    // Show the index page
    @GetMapping("/index")
    public String showIndexPage() {
        return "index";  
    }

    @GetMapping("/plans")
    public String showplans() {
        return "plans";  
    }

    @GetMapping("/createAccount")
    public String showCreateAccount() {
        return "createAccount"; 
    }

}


