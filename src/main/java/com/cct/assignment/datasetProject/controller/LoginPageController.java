package com.cct.assignment.datasetProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cct.assignment.datasetProject.model.User;

@Controller
@RequestMapping("/")
public class LoginPageController {
    
    @GetMapping("/")
    public String showLoginPage(Model model) {
    	 model.addAttribute("user", new User());
        return "crudoperations"; 
    }
}
