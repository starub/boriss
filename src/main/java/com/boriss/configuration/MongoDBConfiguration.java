package com.boriss.configuration;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@ConfigurationProperties("mongo")
public class MongoDBConfiguration extends MongoAutoConfiguration {

	private MongoClientURI uri;

	@Bean
	@Override
	public Mongo mongo() throws UnknownHostException {
		return new MongoClient(uri);
	}

	public void setUri(MongoClientURI uri) {
		this.uri = uri;
	}

}
