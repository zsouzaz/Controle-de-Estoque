package com.zsouzaz.estoque.service;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zsouzaz.estoque.entity.Permission;
import com.zsouzaz.estoque.interfaces.PermissionRepository;

@Service
public class PermissionService {
	private final PermissionRepository permissionRepository;
	
	public PermissionService(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;
	}
	
	public void createPermission(Permission permission) {
		permissionRepository.save(permission);
	}
	
	public Permission findPermissionById(Long id) {
		return permissionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Permissão não encontrada no banco de dados."));
	}
	
	public void updatePermisson(Long id, Permission permission) {
		Permission permissonDB = findPermissionById(id);
		BeanUtils.copyProperties(permission, permissonDB);
		permissionRepository.save(permissonDB);
	}
	
	public void deletePermission(Long id) {
		Permission permissionDB = findPermissionById(id);
		permissionRepository.delete(permissionDB);
	}
}
