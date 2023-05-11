package com.cct.assignment.datasetProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cct.assignment.datasetProject.model.EmissionCountryItem;

@Repository
public interface EmissionRepository extends MongoRepository<EmissionCountryItem, String> {
	
	//Retrieves all emission country items with pagination support
	Page<EmissionCountryItem> findAll(Pageable pageable);
}
