package com.boriss.application.kurento.entity;

public class Response {

	private CommandType command;

	private Status status;

	private String data;

	public CommandType getCommand() {
		return command;
	}

	public void setCommand(CommandType command) {
		this.command = command;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("Response [command=%s, status=%s, data=%s]", command, status, data);
	}

}
