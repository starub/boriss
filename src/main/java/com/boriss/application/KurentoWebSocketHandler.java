package com.boriss.application;

import org.kurento.client.KurentoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class KurentoWebSocketHandler extends TextWebSocketHandler {

    private Logger log = LoggerFactory.getLogger(KurentoWebSocketHandler.class);

    @Autowired
    KurentoClient kurentoClient;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.debug("Received message : {}", message.toString());
    }

}
