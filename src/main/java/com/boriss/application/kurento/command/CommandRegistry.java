package com.boriss.application.kurento.command;

import static com.boriss.application.kurento.command.CommandRegistry.Actions.PING;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMap;

@Component
public class CommandRegistry {

	@Autowired
	PingCommand pingCommand;

	private Map<Actions, Command> commands;

	@PostConstruct
	@VisibleForTesting
	void init() {
		commands = ImmutableMap.<Actions, Command> builder()

		.put(PING, pingCommand).build();
	}

	Command get(String action) {
		return commands.get(Actions.valueOf(action));
	}

	enum Actions {
		PING
	}

}
