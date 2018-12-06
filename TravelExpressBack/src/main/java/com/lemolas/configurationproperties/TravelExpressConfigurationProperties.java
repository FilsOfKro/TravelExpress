package com.lemolas.configurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "travelexpress")
public class TravelExpressConfigurationProperties {

	private MongoConfigurationProperties mongodb = new MongoConfigurationProperties();

	public MongoConfigurationProperties getMongodb() {
		return mongodb;
	}

	public void setMongodb(MongoConfigurationProperties mongodb) {
		this.mongodb = mongodb;
	}

}
