package com.boriss.application.kurento.command;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boriss.application.kurento.entity.CommandType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;

@Component
public class CommandRegistry {

	@Autowired
	PingCommand pingCommand;

	private Map<CommandType, Command> commands;

	@PostConstruct
	@VisibleForTesting
	void init() {
		commands = ImmutableMap.<CommandType, Command> builder().put(CommandType.PING, pingCommand).build();
	}

	Command get(String action) {
		return commands.get(CommandType.valueOf(action));
	}

}
