package com.cct.assignment.dataProject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

// MongoDB configurations for Springboot connection
@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {

	// Specify the name of the MongoDB database 
	@Override
	protected String getDatabaseName() {
		return "co2emissions";
	}

	// Enable auto-creation of indexes for MongoDB collections
	@Override
	protected boolean autoIndexCreation() {
		return true;
	}

}
