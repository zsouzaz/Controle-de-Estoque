package com.example.estoque.controller;

import java.util.List;
import com.example.estoque.entity.UserRequestDTO;
import org.springframework.web.bind.annotation.*;
import com.example.estoque.entity.User;
import com.example.estoque.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	// Injetando dependencias
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Método HTTP responsável por receber a requisição para criar usuário.
	@PostMapping
	public void createUser(@RequestBody UserRequestDTO userRequestDTO) {
		userService.createUser(userRequestDTO.getUser(), userRequestDTO.getPermissions());
	}

	// Busca usuário por ID.
	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.findUserById(id);
	}

	// Busca todos usuários.
	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	// Edita usuário.
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user, @RequestBody List<Long> permissoes) {
		return userService.updateUser(id, user, permissoes);
	}

	// Deleta usuário por ID.
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUser(
				userService.findUserById(id)
		);
	}
}
