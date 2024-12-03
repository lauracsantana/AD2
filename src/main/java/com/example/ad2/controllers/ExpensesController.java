package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpensesController {

    // Mapping for the Expenses Page
    @GetMapping("/expenses")
    public String showExpensesPage() {
        return "expenses"; // Refers to "expenses.html" Thymeleaf template
    }

    // Mapping for the Add Income Page
    @GetMapping("/addIncome")
    public String showAddIncomePage() {
        return "addIncome"; // Refers to "add_income.html" Thymeleaf template
    }

    // Mapping for the Add Expenses Page
    @GetMapping("/addExpenses")
    public String showAddExpensesPage() {
        return "addExpenses"; // Refers to "add_expenses.html" Thymeleaf template
    }
}
