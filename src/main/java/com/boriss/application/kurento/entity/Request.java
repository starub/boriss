package com.boriss.application.kurento.entity;

public class Request {

	private String command;

	private String data;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Request [command=%s, data=%s]", command, data);
	}

}
