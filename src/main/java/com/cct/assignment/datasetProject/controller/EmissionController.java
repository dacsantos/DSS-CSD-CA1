package com.cct.assignment.datasetProject.controller;

//import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

import com.cct.assignment.datasetProject.model.Emission;
import com.cct.assignment.datasetProject.repository.EmissionRepository;

@Controller
public class EmissionController {

    @Autowired
    private EmissionRepository emissionRepository;

//    @GetMapping("/emissions")
//    public String getEmissions(Model model) {
//        List<Emission> emissions = emissionRepository.findAll();     
//        model.addAttribute("emissions", emissions);
//        return "emissions";
//    }
    
    @GetMapping("/emissions")
    public String getEmissions(
        Model model,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "year,asc") String[] sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Emission> emissionsPage = emissionRepository.findAll(pageable);

        model.addAttribute("emissions", emissionsPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", emissionsPage.getTotalPages());

        return "emissions";
    }

}
