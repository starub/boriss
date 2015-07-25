package com.boriss.application.kurento.entity;

public class Request {

	private String command;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return String.format("Request [command=%s]", command);
	}
	
	
}
