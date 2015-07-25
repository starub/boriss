package com.boriss.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
@ConfigurationProperties("application")
public class ApplicationConfiguration {

	private String webSocketEndpoint;

	@Bean
	public Gson gson() {
		return new GsonBuilder().create();
	}

	public String getWebSocketEndpoint() {
		return webSocketEndpoint;
	}

	public void setWebSocketEndpoint(String webSocketEndpoint) {
		this.webSocketEndpoint = webSocketEndpoint;
	}
}
