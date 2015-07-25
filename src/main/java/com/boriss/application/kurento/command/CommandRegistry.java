package com.boriss.application.kurento.command;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boriss.application.kurento.entity.CommandType;
import com.google.common.collect.ImmutableMap;

@Component
public class CommandRegistry {

	@Autowired
	private PingCommand pingCommand;
	
	@Autowired
	private SDPOfferCommand sdpOfferCommand;

	private Map<CommandType, Command> commands;

	public Command get(String action) {
		return commands.get(CommandType.valueOf(action));
	}

	@PostConstruct
	private void init() {
		commands = ImmutableMap.<CommandType, Command> builder()
				.put(CommandType.PING, pingCommand)
				.put(CommandType.SDP_OFFER,sdpOfferCommand)
				.build();
	}

}
