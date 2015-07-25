package com.boriss.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application")
public class ApplicationConfiguration {

	private String webSocketEndpoint;

	public String getWebSocketEndpoint() {
		return webSocketEndpoint;
	}

	public void setWebSocketEndpoint(String webSocketEndpoint) {
		this.webSocketEndpoint = webSocketEndpoint;
	}
}
