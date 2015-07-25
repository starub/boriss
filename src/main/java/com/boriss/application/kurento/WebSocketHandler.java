package com.boriss.application.kurento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.boriss.application.kurento.command.CommandHandler;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

	private Logger log = LoggerFactory.getLogger(WebSocketHandler.class);

	@Autowired
	CommandHandler commandHandler;

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("Received WebSocket message : {}", message.toString());
		commandHandler.handle(session, message);
	}

}
