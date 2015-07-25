package com.boriss.application.kurento.command;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class PingCommand implements Command {

	@Override
	public void execute(WebSocketSession session, TextMessage message) throws Exception {
		session.sendMessage(new TextMessage("PONG!"));
	}

}
