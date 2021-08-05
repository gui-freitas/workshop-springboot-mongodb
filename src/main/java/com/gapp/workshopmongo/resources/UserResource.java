package com.gapp.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapp.workshopmongo.domain.User;
import com.gapp.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = userservice.findAll();
		return ResponseEntity.ok().body(list);
	}
}