package com.example.estoque.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.estoque.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
