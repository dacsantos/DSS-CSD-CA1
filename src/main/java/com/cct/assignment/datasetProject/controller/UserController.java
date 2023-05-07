package com.cct.assignment.datasetProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cct.assignment.datasetProject.model.User;
import com.cct.assignment.datasetProject.repository.UserRepository;
import com.cct.assignment.datasetProject.service.SequenceGeneratorService;
import com.cct.assignment.datasetProject.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);

	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		return userRepository.save(user);
	}

	@PutMapping("/users/{id}")
    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long userId,
        @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
			    .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        user.setUsername(userDetails.getUsername() );
        user.setPassword(userDetails.getPassword());
        final User updatedUser= userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

	@DeleteMapping("/users/{id}")
    public Map < String, Boolean > deleteUser(@PathVariable(value = "id") Long userId)
    throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
			    .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

        userRepository.delete(user);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}