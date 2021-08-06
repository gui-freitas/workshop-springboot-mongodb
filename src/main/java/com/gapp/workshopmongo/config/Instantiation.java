package com.gapp.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gapp.workshopmongo.domain.Post;
import com.gapp.workshopmongo.domain.User;
import com.gapp.workshopmongo.dto.AuthorDTO;
import com.gapp.workshopmongo.dto.CommentDTO;
import com.gapp.workshopmongo.repository.PostRepository;
import com.gapp.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T19:53:07Z"), "Parviu viagem", "Vou viajar para Sâo Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, Instant.parse("2018-03-23T07:41:00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", Instant.parse("2018-03-21T20:10:00Z"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", Instant.parse("2018-03-22T09:32:23Z"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2018-03-23T08:20:49Z"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
		
		
	}
}