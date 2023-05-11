package com.cct.assignment.datasetProject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cct.assignment.datasetProject.exception.ResourceNotFoundException;
import com.cct.assignment.datasetProject.model.User;
import com.cct.assignment.datasetProject.repository.UserRepository;
import com.cct.assignment.datasetProject.service.SequenceGeneratorService;

@Controller
public class UserPageController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	// Method to display the list of users
	@RequestMapping("/listuserspage")
	public String ListUsersPage(Model model) {
		var users = userRepository.findAll();
		model.addAttribute("users", users);

		return "listuserspage";
	}

	// Method to create a new user, save to repository, and redirect to the list of users page
	@PostMapping("/createuser")
	public String CreateUser(@Valid @ModelAttribute User user) {
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		userRepository.save(user);
		
		return "redirect:/listuserspage";
	}
	// Display the update user page
	@GetMapping("/updateuser/{id}")
	public String UpdateUserPage(Model model, @PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		// Find the user by ID in the repository, or throw an exception if not found
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		model.addAttribute("user", user);
		
		return "updateuserpage";
	}
	//  Updating a user
	@PostMapping("/updateuser")
	public String UpdateUser(@Valid @ModelAttribute User userRequest) throws ResourceNotFoundException {
		User user = userRepository.findById(userRequest.getId()).orElseThrow(
				() -> new ResourceNotFoundException("User not found for this id :: " + userRequest.getId()));
		user.setUsername(userRequest.getUsername());
		user.setPassword(userRequest.getPassword());
		userRepository.save(user);

		return "redirect:/listuserspage";
	}

	// Delete a user
	@RequestMapping("/deleteuser/{id}")
	public String ListUsersPage(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return "redirect:/listuserspage";
	}
}