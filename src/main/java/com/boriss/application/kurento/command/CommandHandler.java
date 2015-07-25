package com.boriss.application.kurento.command;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public interface CommandHandler {

	void handle(WebSocketSession session, TextMessage message) throws Exception;
}
