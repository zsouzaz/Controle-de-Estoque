package com.zsouzaz.estoque.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zsouzaz.estoque.interfaces.UserRepository;

public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByName(username)
				.map(UserAuthenticated::new)
				.orElseThrow(() -> new UsernameNotFoundException("Nome não encontrado."));
	}
	
}
