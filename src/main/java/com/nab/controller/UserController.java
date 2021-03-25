package com.nab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.db.UserRepository;
import com.nab.model.User;

@RestController
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping()
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/add")
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
