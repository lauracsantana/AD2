package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/another_day_another_dollar") 
public class PlanningController {

    // // Mapping for the Planning Page
    // @GetMapping("/planning")
    // public String showPlanningPage() {
    //     return "planning"; 
    // }

    // Mapping for the Budget Page
    @GetMapping("/setBudget")
    public String showBudgetPage() {
        return "setBudget";
    }

    // Mapping for the Bills Page
    @GetMapping("/bills")
    public String showBillsPage() {
        return "bills"; 
    }

    // Mapping for the Goals Page
    @GetMapping("/goals")
    public String showGoalsPage() {
        return "goals"; 
    }
}
