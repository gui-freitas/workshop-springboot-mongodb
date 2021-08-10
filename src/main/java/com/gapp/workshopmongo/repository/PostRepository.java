package com.gapp.workshopmongo.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gapp.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title': { $regex: ?0, $options: 'i' } } ")
	List<Post> findByTitle(String text);
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> find(String text, Instant minDate, Instant maxDate);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}