package com.example.estoque.service;

import com.example.estoque.entity.Product;
import com.example.estoque.interfaces.ProductRepository;

import org.hibernate.internal.build.AllowSysOut;
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
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Deleta um usuário.
    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return findAll();
    }

    public List<Product> update(Long id, Product productNew) {
        Optional<Product> optionalProduct = findById(id);
        if (optionalProduct.isPresent()) {
            Product productGet = optionalProduct.get();
            //Passando as propriedades atualizadas para a entidade no banco.
        	BeanUtils.copyProperties(productNew, productGet);
            productRepository.save(productGet);
        } else {
        	// Resposta alternativa caso não encontre um usuário.
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
		return findAll();
    }
}
