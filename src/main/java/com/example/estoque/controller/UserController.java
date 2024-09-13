package com.example.estoque.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.estoque.entity.User;
import com.example.estoque.service.UserService;

@Controller
@RequestMapping(name = "/users")
public class UserController {
	private UserService userService;
	
	// Injetando dependencias
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// Método HTTP responsável por receber a requisição para criar usuário.
	@PostMapping
	public void createUser(@RequestBody User user, @RequestBody Set<String> permissoes) {
	//	userService.createUser(user, permissoes);
	}
}
