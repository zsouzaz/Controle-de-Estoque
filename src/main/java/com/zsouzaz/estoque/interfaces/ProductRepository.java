package com.zsouzaz.estoque.interfaces;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zsouzaz.estoque.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public Optional<Product> findProductByCodBarras(String codBarras);
}
