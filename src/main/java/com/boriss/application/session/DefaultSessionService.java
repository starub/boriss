package com.boriss.application.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boriss.domain.session.Session;
import com.boriss.domain.session.SessionRepository;
import com.boriss.domain.user.User;

@Service
public class DefaultSessionService implements SessionService {

	@Autowired
	SessionRepository repository;

	@Override
	public Session create(User caller, User callee) {

		Session session = new Session();

		repository.insert(session);

		return session;
	}

}
