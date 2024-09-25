package com.zsouzaz.estoque.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zsouzaz.estoque.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
