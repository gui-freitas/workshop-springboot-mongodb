package com.gapp.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gapp.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}