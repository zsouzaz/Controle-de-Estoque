package com.zsouzaz.estoque.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zsouzaz.estoque.entity.Permission;
import com.zsouzaz.estoque.entity.User;
import com.zsouzaz.estoque.entity.UserRequestDTO;
import com.zsouzaz.estoque.interfaces.UserRepository;

// Criando regras de negócio para classe usuários

// *** Fazer verificação para que apenas usuários ADM exerçam essas funções. ***

@Service
public class UserService {
	private UserRepository userRepository;
	private PermissionService permissionService;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	// injetando dependencias.
	public UserService(UserRepository userRepository, PermissionService permissionService) {
		this.userRepository = userRepository;
		this.permissionService = permissionService;
	}
	
	public void createUser(UserRequestDTO userRequestDTO) {
		User user = new User();
		Set<Permission> permissions = new HashSet<Permission>();
		userRequestDTO.getPermissions().forEach(id -> {
			permissions.add(permissionService.findPermissionById(id));
		});
		BeanUtils.copyProperties(userRequestDTO.getUser(), user);
		user.setPermissoes(permissions);
		user.setSenha(passwordEncoder.encode(userRequestDTO.getUser().getSenha()));
		userRepository.save(user);
	}
	
	public User findUserByName(String name) {
		return userRepository.findUserByNome(name)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() ->  new RuntimeException("Usuário não encontrado."));
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User updateUser(Long id, UserRequestDTO userRequestDTO) {
		User userDB = findUserById(id);
		Set<Permission> permissions = new HashSet<Permission>();
		userRequestDTO.getPermissions().forEach(ids -> {
			permissions.add(permissionService.findPermissionById(ids));
		});
		BeanUtils.copyProperties(userRequestDTO.getUser(), userDB);
		userDB.setPermissoes(permissions);
		userDB.setSenha(passwordEncoder.encode(userRequestDTO.getUser().getSenha()));
		return userRepository.save(userDB);
	}
	
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public void deleteUser(Long id) {
		User userDB = findUserById(id);
		userRepository.delete(userDB);
	}	
}
