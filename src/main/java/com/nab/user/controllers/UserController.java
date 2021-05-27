package com.nab.user.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.user.db.UserRepository;
import com.nab.model.User;

@RestController
@RequestMapping("users")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("{id}")
	public User getUsers(long userId) {
		return userRepository.findById(userId).get();
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@DeleteMapping(path = { "/{id}" })
	public User deleteUser(@PathVariable("id") long id) {
		User user = userRepository.getOne(id);
		userRepository.deleteById(id);
		return user;
	}

}
