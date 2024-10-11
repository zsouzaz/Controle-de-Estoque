package com.zsouzaz.estoque.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public String authenticate() {
		return "token";
	}
}
