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

        KurentoClient client = KurentoClient.create(getWebsocketUrl(), new KurentoConnectionListener() {

            @Override
            public void disconnected() {
                log.debug("Kurento client disconnected.");
            }

            @Override
            public void connectionTimeout() {
                log.debug("Kurento client connection timeout.");
            }

            @Override
            public void connected() {
                log.debug("Kurento client connected.");
            }
        });

        return client;
    }

    public String getWebsocketUrl() {
        return websocketUrl;
    }

    public void setWebsocketUrl(String websocketUrl) {
        this.websocketUrl = websocketUrl;
    }

}
