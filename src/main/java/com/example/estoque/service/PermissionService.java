package com.example.estoque.service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.example.estoque.entity.Permission;
import com.example.estoque.interfaces.PermissionRepository;

@Service
public class PermissionService {
	private final PermissionRepository permissionRepository;
	
	public PermissionService(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
	
	// Cria permissões.
	public void createPermission(Permission permission) {
		permissionRepository.save(permission);
	}
	
	// Busca permissão por ID.
	public Permission findPermissionById(Long id) {
		return permissionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Permissão não encontrada no banco de dados."));
	}
	
	// Edita permissão
	public void updatePermisson(Long id, Permission permission) {
		Permission permissonDB = findPermissionById(id);
		BeanUtils.copyProperties(permission, permissonDB);
		permissionRepository.save(permissonDB);
	}
	
	// Deleta permissão
	public void deletePermission(Long id) {
		Permission permissionDB = findPermissionById(id);
		permissionRepository.delete(permissionDB);
	}
} 
