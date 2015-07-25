package com.boriss.configuration;

import java.io.IOException;

import org.kurento.client.KurentoClient;
import org.kurento.client.KurentoConnectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("kurento")
public class KurentoConfiguration {

	private Logger log = LoggerFactory.getLogger(KurentoConfiguration.class);

	private String websocketUrl;

	@Bean
	KurentoClient kurentoClient() throws IOException {

		KurentoClient client = KurentoClient.create(websocketUrl, new KurentoConnectionListener() {

			@Override
			public void disconnected() {
				log.debug("Kurento client disconnected.");
			}

			@Override
			public void connected() {
				log.debug("Kurento client connected.");
			}

			@Override
			public void connectionFailed() {
				log.debug("Kurento client connection failed.");
			}

			@Override
			public void reconnected(boolean sameServer) {
				log.debug("Kurento client reconnected, same server : {}", sameServer);
			}
		});

		return client;
	}

	public void setWebsocketUrl(String websocketUrl) {
		this.websocketUrl = websocketUrl;
	}

}
