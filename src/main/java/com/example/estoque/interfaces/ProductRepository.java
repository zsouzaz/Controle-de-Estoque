package com.example.estoque.interfaces;

import com.example.estoque.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Nomeia uma interface responsável pelas buscas e modificações no banco.
public interface ProductRepository extends JpaRepository<Product, Long> {
}
