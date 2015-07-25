package com.boriss.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Iterables;
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.application.Applications;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;

@Configuration
@ConfigurationProperties("stormpath")
public class StormpathConfiguration {

	private String id;

	private String secret;

	@Bean
	public Application stormpathApplication() {
		return Iterables.getOnlyElement(stormpathClient().getCurrentTenant()
				.getApplications(Applications.where(Applications.name().eqIgnoreCase("boriss"))));
	}

	@Bean
	public Client stormpathClient() {
		return Clients.builder().setApiKey(ApiKeys.builder().setId(id).setSecret(secret).build()).build();
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
