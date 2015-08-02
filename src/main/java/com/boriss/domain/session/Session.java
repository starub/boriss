package com.boriss.domain.session;

import org.springframework.data.annotation.Id;

public class Session {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
