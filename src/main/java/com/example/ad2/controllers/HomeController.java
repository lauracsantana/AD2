package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/another_day_another_dollar") 
public class HomeController {
    
    @GetMapping("/homePage")
    public String showHomePage() {
        return "homePage"; 
    }
    
    @GetMapping("/expenses")
    public String showHomeExpensesPage() {
        return "expenses"; 
    }

    @GetMapping("/planning")
    public String showHomePlanningPage() {
        return "planning"; 
    }

    @GetMapping("/debits")
    public String showHomeDebitsPage() {
        return "debits"; 
    }

    @GetMapping("/analytics")
    public String showHomeAnalyticsPage() {
        return "analytics"; 
    }

}
