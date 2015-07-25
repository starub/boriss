package com.boriss.application.kurento.command;

import com.boriss.application.kurento.entity.Request;
import com.boriss.application.kurento.entity.Response;

public interface Command {

	Response execute(Request request) throws Exception;

}
