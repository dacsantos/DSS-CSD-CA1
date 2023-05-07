package com.cct.assignment.datasetProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cct.assignment.datasetProject.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
