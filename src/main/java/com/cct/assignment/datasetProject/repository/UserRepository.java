package com.cct.assignment.datasetProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cct.assignment.datasetProject.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
	
	/**
	 * Finds a user by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user with the matching username and password, or null if not found
	 */
	User findByUsernameAndPassword(String username, String password);
	
	/**
	 * Checks if a user exists with the given username.
	 *
	 * @param username the username
	 * @return true if a user with the given username exists, false otherwise
	 */
	Boolean existsByUsername(String username);

}
