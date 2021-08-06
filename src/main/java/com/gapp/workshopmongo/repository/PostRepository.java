package com.gapp.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gapp.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}