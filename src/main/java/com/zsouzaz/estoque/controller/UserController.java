package com.zsouzaz.estoque.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.zsouzaz.estoque.entity.User;
import com.zsouzaz.estoque.entity.UserRequestDTO;
import com.zsouzaz.estoque.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	// Injetando dependencias
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public void createUser(@RequestBody UserRequestDTO userRequestDTO) {
		userService.createUser(userRequestDTO);
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
		return userService.updateUser(id, userRequestDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUser(
				userService.findUserById(id)
		);
	}
}
