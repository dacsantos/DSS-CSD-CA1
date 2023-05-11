package com.cct.assignment.datasetProject.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cct.assignment.datasetProject.model.EmissionCountryItem;
import com.cct.assignment.datasetProject.repository.EmissionRepository;


@Controller
public class EmissionController {

    @Autowired
    private EmissionRepository emissionRepository;
    // Displays the emissions page
    @GetMapping("/emissions")
    public String getEmissions(Model model) {
    	// Retrieve all emission data from the repository and add to the model
        List<EmissionCountryItem> emissions = emissionRepository.findAll();
        model.addAttribute("emissions", emissions);
        return "emissions";
    }


}
