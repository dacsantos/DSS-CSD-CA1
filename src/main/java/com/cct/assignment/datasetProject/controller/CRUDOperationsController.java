package com.cct.assignment.datasetProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cct.assignment.datasetProject.model.User;

@Controller
public class CRUDOperationsController {
    
    @GetMapping("/crudoperations")
    public String showCrudOperationsPage(Model model) {
    	 model.addAttribute("user", new User());
        return "crudoperations"; // Return the name of the HTML template file (crudoperations.html)
    }
}
