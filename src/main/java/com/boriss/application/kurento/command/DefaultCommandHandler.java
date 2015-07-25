package com.boriss.application.kurento.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.boriss.application.kurento.entity.Request;
import com.boriss.application.kurento.entity.Response;
import com.google.gson.Gson;

@Component
public class DefaultCommandHandler implements CommandHandler {

	@Autowired
	Gson gson;

	@Autowired
	CommandRegistry registry;

	@Override
	public void handle(WebSocketSession session, TextMessage message) throws Exception {

		Request request = gson.fromJson(message.getPayload(), Request.class);

		Command command = registry.get(request.getCommand());

		Response response = command.execute(request);

		session.sendMessage(new TextMessage(gson.toJson(response)));

	}

}
