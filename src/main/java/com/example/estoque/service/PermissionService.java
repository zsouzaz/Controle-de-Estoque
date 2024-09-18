package com.example.estoque.service;
import org.springframework.stereotype.Service;
import com.example.estoque.entity.Permission;
import com.example.estoque.interfaces.PermissionRepository;

@Service
public class PermissionService {
	private final PermissionRepository permissionRepository;
	
	public PermissionService(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
	
	// Recebe as permissões como String e repassa como um Set(Array que permite apenas valores únicos) de Roles.
	public void createPermission(Permission permission) {
		permissionRepository.save(permission);		
	}
	
}
