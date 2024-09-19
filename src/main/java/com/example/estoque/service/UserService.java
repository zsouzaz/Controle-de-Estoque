package com.example.estoque.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.estoque.entity.Permission;
import com.example.estoque.entity.User;
import com.example.estoque.interfaces.UserRepository;

// Criando regras de negócio para classe usuários

// *** Fazer verificação para que apenas usuários ADM exerçam essas funções. ***

@Service
public class UserService {
	private UserRepository userRepository;
	
	// injetando dependencias.
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// Adiciona as permissões ao usuário e persiste no banco.
	public void createUser(User user, Set<Permission> permissions) {
		user.setPermissoes(permissions); // Quando o service das permissões for finalizado, fazer as buscas por ele aqui. Deverá receber somente os ID's as permissões.
		userRepository.save(user);
	}
	
	// Busca usuários por ID.
	public User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() ->  new RuntimeException("Usuário não encontrado."));
	}
	
	// Busca todos os usuários.
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	// Atualizar usuários.
	public User updateUser(Long id, User user) {
		User userDB = findUserById(id);
		BeanUtils.copyProperties(user, userDB);
		return userRepository.save(userDB);
	}
	
	// Remove usuário.
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	// Remove usuário por Id;
	public void deleteUser(Long id) {
		User userDB = findUserById(id);
		userRepository.delete(userDB);
	}
	
	
}
