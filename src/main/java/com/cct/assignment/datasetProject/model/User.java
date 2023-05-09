package com.cct.assignment.datasetProject.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long id;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	@NotEmpty(message = "username should not be empty")
	private String username;

	@NotEmpty(message = "Password should not be empty")
	private String password;

	public User() {
	}

	// private User(long id, String username, String password) {
	// super();
	// this.id = id;
	// this.username = username;
	// this.password = password;
	// }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
