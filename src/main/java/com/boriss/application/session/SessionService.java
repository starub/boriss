package com.boriss.application.session;

import com.boriss.domain.session.Session;
import com.boriss.domain.user.User;

public interface SessionService {

	Session create(User caller, User callee);
}
