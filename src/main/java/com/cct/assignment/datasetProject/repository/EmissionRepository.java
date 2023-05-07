package com.cct.assignment.datasetProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cct.assignment.datasetProject.model.Emission;

@Repository
public interface EmissionRepository extends MongoRepository<Emission, String> {
	Page<Emission> findAll(Pageable pageable);
}

