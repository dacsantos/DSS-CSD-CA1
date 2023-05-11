package com.cct.assignment.datasetProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cct.assignment.datasetProject.model.User;
import com.cct.assignment.datasetProject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Saves or updates the user in the database.
	 *
	 * @param user the user to be saved or updated
	 * @return the saved or updated user
	 */
	public User saveOrUpdate(User user) {
		return userRepository.save(user);

	}

	/**
	 * Retrieves all users from the database.
	 *
	 * @return a list of all users
	 */
	public List<User> findAll() {

		return userRepository.findAll();

	}

}
