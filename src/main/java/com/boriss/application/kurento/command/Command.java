package com.boriss.application.kurento.command;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public interface Command {

	void execute(WebSocketSession session, TextMessage message) throws Exception;

}
