package com.example.ad2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/another_day_another_dollar")
public class DebitsController {

// Show the checklist page
@GetMapping("/checkList")
public String showChecklistPage() {
    return "checkList";
}

// Show the loans page
@GetMapping("/loans")
public String showLoansPage() {
    return "loans"; 
}

}

