package com.cct.assignment.datasetProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cct.assignment.datasetProject.model.User;
import com.cct.assignment.datasetProject.repository.UserRepository;


@Controller
@RequestMapping("/")
public class LoginController {
	
    @Autowired
    private UserRepository userRepository;

    // Method that processes the login form submission
    @PostMapping("/loginpage")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            // User found, login successful
            return "redirect:/listuserspage"; 
        } else {
            // Invalid credentials, login failed
            return "redirect:/?error";
        }
    }
}
