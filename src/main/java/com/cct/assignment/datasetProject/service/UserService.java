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
	
	public User saveOrUpdate(User user) {
		return userRepository.save(user) ;
		
	}
	
	public List<User> findAll(){
		
		return userRepository.findAll();
		
	}

}
