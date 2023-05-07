package com.cct.assignment.datasetProject.service;

import org.springframework.data.domain.Page;
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

    public Page<Emission> getAllEmissionsByCountry(Pageable pageable) {
        return emissionRepository.findAll(pageable);
    }
}
