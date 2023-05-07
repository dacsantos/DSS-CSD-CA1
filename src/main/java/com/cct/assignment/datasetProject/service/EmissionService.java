package com.cct.assignment.datasetProject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cct.assignment.datasetProject.model.Emission;
import com.cct.assignment.datasetProject.repository.EmissionRepository;

@Service
public class EmissionService {
	private final EmissionRepository emissionRepository;

	public EmissionService(EmissionRepository emissionsByCountryRepository) {
		this.emissionRepository = emissionsByCountryRepository;
	}

//    public Page<Emission> getAllEmissionsByCountry(Pageable pageable) {
//        return emissionRepository.findAll(pageable);
//    }

	public Page<Emission> findPage(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 5);
		return emissionRepository.findAll(pageable);
	}
}
