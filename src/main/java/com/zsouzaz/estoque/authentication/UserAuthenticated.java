package com.zsouzaz.estoque.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.zsouzaz.estoque.entity.User;

public class UserAuthenticated implements UserDetails{
	private final User user;
	
	public UserAuthenticated(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) user.getPermissoes();
	}

	@Override
	public String getPassword() {		
		return user.getSenha();
	}

	@Override
	public String getUsername() {
		return user.getNome();
	}	
}
