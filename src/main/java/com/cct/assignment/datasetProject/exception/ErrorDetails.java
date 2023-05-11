package com.cct.assignment.datasetProject.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp; // Time stamp of the error
	private String message; // Error message
	private String details; // Additional details about the error

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}