package com.boriss.application.kurento.command;

import org.springframework.stereotype.Component;

import com.boriss.application.kurento.entity.CommandType;
import com.boriss.application.kurento.entity.Request;
import com.boriss.application.kurento.entity.Response;
import com.boriss.application.kurento.entity.Status;

@Component
public class PingCommand implements Command {

	@Override
	public Response execute(Request request) throws Exception {

		Response response = new Response();

		response.setCommand(CommandType.PING);
		response.setStatus(Status.OK);
		response.setData("PONG!");

		return response;
	}

	@Override
	public String toString() {
		return CommandType.PING.name();
	}

}
