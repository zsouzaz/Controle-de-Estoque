package com.zsouzaz.estoque.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zsouzaz.estoque.authentication.AuthenticationService;

@RestController
public class AuthenticationController {
	private final AuthenticationService authenticationService;

	public AuthenticationController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	 
	@PostMapping("/authenticate")
	public String authenticate(Authentication authentication) {
		return authenticationService.authenticate(authentication); 
	}
}
