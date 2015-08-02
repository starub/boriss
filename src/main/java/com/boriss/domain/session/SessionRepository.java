package com.boriss.domain.session;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionRepository extends MongoRepository<Session, Serializable> {

}
