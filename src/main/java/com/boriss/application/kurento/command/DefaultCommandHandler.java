package com.boriss.application.kurento.command;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.boriss.application.kurento.entity.CommandType;
import com.boriss.application.kurento.entity.Request;
import com.boriss.application.kurento.entity.Response;
import com.boriss.application.kurento.entity.Status;
import com.google.gson.Gson;

@Component
public class DefaultCommandHandler implements CommandHandler {

	private final Logger log = LoggerFactory.getLogger(CommandHandler.class);

	@Autowired
	Gson gson;

	@Autowired
	CommandRegistry registry;

	@Override
	public void handle(WebSocketSession session, TextMessage message) throws Exception {

		try {

			Request request = gson.fromJson(message.getPayload(), Request.class);

			log.debug("Received Kurento request : {}", request);

			Command command = registry.get(request.getCommand());

			log.debug("Executing command : {}", command);

			Response response = command.execute(request);

			log.debug("Execution result : {}", response);

			session.sendMessage(new TextMessage(gson.toJson(response)));

		} catch (Exception e) {

			log.debug("Exception handling WebSocket message : {}", message, e);

			Response response = new Response();

			response.setStatus(Status.FAIL);
			response.setCommand(CommandType.UNKNOWN);
			response.setData(ExceptionUtils.getStackTrace(e));

			session.sendMessage(new TextMessage(gson.toJson(response)));
		}

	}

}
