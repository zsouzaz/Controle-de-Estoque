package com.example.estoque.service;

import com.example.estoque.entity.Product;
import com.example.estoque.interfaces.ProductRepository;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Entidade responsável pelas regras de negócio da classe "Usuário" do sistema.
@Service
public class ProductService {
    private ProductRepository productRepository;

    // Injeção de dependencias.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Retorna uma lista com todos os usuários para fins didáticos (melhor visualização no postman).
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Adiciona um novo usuário
    public List<Product> create(Product product) {
        productRepository.save(product);
        return findAll();
    }
    
    // Busca um usuário
    public Product findById(Long id) {
        return productRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    // Deleta um usuário.
    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return findAll();
    }

    public List<Product> update(Long id, Product productNew) {
        Product productDB = findById(id);
        //Passando as propriedades atualizadas para a entidade no banco.
    	BeanUtils.copyProperties(productNew, productDB);
        productRepository.save(productDB);
        // Retorna todos os usuários se atualizado ou não.
		return findAll();
    }
    
    public Product findProductByCodBarras(String codBarras) {
    	return productRepository.findProductByCodBarras(codBarras)
    			.orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }
}
