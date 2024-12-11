package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path ="/another_day_another_dollar") 
public class ExpensesController {

    // Mapping for the Add Income Page
    @GetMapping("/addIncome")
    public String showAddIncomePage() {
        return "addIncome"; 
    }

    // Mapping for the Add Expenses Page
    @GetMapping("/addExpenses")
    public String showAddExpensesPage() {
        return "addExpenses"; 
    }
}
