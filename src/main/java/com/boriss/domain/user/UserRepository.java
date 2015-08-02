package com.boriss.domain.user;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Serializable> {

}
