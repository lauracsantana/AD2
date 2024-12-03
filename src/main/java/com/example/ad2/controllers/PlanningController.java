package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlanningController {

    // Mapping for the Planning Page
    @GetMapping("/planning")
    public String showPlanningPage() {
        return "planning"; 
    }

    // Mapping for the Budget Page
    @GetMapping("/set_budget")
    public String showBudgetPage() {
        return "set_budget";
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
