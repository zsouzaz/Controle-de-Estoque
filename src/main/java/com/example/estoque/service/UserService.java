package com.example.estoque.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.estoque.entity.Permission;
import com.example.estoque.entity.User;
import com.example.estoque.entity.UserRequestDTO;
import com.example.estoque.interfaces.UserRepository;

// Criando regras de negócio para classe usuários

// *** Fazer verificação para que apenas usuários ADM exerçam essas funções. ***

@Service
public class UserService {
	private UserRepository userRepository;
	private PermissionService permissionService;
	
	// injetando dependencias.
	public UserService(UserRepository userRepository, PermissionService permissionService) {
		this.userRepository = userRepository;
		this.permissionService = permissionService;
	}
	
	// Adiciona as permissões ao usuário e persiste no banco.
	public void createUser(UserRequestDTO userRequestDTO) {
		User user = new User();
		Set<Permission> permissions = new HashSet<Permission>();
		userRequestDTO.getPermissions().forEach(id -> {
			permissions.add(permissionService.findPermissionById(id));
		});
		BeanUtils.copyProperties(userRequestDTO.getUser(), user);
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
	public User updateUser(Long id, UserRequestDTO userRequestDTO) {
		User userDB = findUserById(id);
		Set<Permission> permissions = new HashSet<Permission>();
		userRequestDTO.getPermissions().forEach(ids -> {
			permissions.add(permissionService.findPermissionById(ids));
		});
		BeanUtils.copyProperties(userRequestDTO.getUser(), userDB);
		userDB.setPermissoes(permissions);
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
