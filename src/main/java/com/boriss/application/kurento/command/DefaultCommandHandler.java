package com.boriss.application.kurento.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class DefaultCommandHandler implements CommandHandler {

	@Autowired
	CommandRegistry registry;

	@Override
	public void handle(WebSocketSession session, TextMessage message) throws Exception {
		registry.get(message.getPayload()).execute(session, message);
	}

}
