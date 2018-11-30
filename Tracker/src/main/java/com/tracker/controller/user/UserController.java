package com.tracker.controller.user;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.model.user.UserDetails;
import com.tracker.service.user.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users/")
	public ResponseEntity<List<UserDetails>> getAllUsers() {
		List<UserDetails> users = new LinkedList<UserDetails>();
		try {
			users = userService.getAllUser();
			return ResponseEntity.ok().body(users);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<UserDetails>> getUser(@PathVariable("id") long id) {
		Optional<UserDetails> user;
		try {
			user = userService.getUser(id);
			return ResponseEntity.ok().body(user);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/user/")
	public  ResponseEntity<String> registerUser(@RequestBody UserDetails userNw) {
		UserDetails add_user;
		try {
			add_user= userService.addUser(userNw);
			return ResponseEntity.status(201).body("User added Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(404).build();
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable int id, @RequestBody UserDetails exstUser) {
		try {
			userService.UpdateUser(exstUser);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable long id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
