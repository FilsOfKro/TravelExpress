package com.lemolas.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.lemolas.configurationproperties.MongoConfigurationProperties;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfiguration {

	private MongoConfigurationProperties mongoProperties;

	@Autowired
	public MongoConfiguration(MongoConfigurationProperties mongoProperties) {
		this.mongoProperties = mongoProperties;
	}

	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(mongoProperties.getHost(), mongoProperties.getPort());
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient client) {
		return new MongoTemplate(client, mongoProperties.getDatabase());
	}
}
