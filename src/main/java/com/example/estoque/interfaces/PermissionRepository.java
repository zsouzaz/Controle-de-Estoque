package com.example.estoque.interfaces;


import com.example.estoque.entity.Permission;
import com.example.estoque.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
