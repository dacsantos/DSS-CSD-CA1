package com.cct.assignment.datasetProject.controller;

//import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;

import com.cct.assignment.datasetProject.model.Emission;
import com.cct.assignment.datasetProject.repository.EmissionRepository;
import com.cct.assignment.datasetProject.service.EmissionService;

@Controller
public class EmissionController {

	@Autowired
	private EmissionRepository emissionRepository;
	private EmissionService emissionService;

    @GetMapping("/emissions")
    public String getEmissions(Model model) {
        List<Emission> emissions = emissionRepository.findAll();     
        model.addAttribute("emissions", emissions);
        return "emissions";
    }

//	@GetMapping("/emissions/{pageNumber}")
//	public String getOnePage(Model model, @PathVariable("pageNumber") int currentPage) {
//		Page<Emission> page = emissionService.findPage(currentPage);
//		int totalPages = page.getTotalPages();
//		long totalItems = page.getTotalElements();
//		List<Emission> emissions = page.getContent();
//
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("totalPages", totalPages);
//		model.addAttribute("totalItems", totalItems);
//		model.addAttribute("emissions", emissions);
//
//		return "emissions";
//	}
	
//	@GetMapping("/emissions")
//	public String getAllPages(Model model) {
//		return getOnePage(model,1);	
//	}
	
}
