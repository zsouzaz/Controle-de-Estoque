package com.zsouzaz.estoque.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zsouzaz.estoque.entity.Permission;
import com.zsouzaz.estoque.entity.Product;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
