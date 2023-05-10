package com.cct.assignment.datasetProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cct.assignment.datasetProject.model.EmissionCountryItem;

@Repository
public interface EmissionRepository extends MongoRepository<EmissionCountryItem, String> {
	Page<EmissionCountryItem> findAll(Pageable pageable);
}

