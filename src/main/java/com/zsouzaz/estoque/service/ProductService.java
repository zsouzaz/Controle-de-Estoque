package com.zsouzaz.estoque.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.zsouzaz.estoque.entity.Product;
import com.zsouzaz.estoque.interfaces.ProductRepository;

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

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> create(Product product) {
        productRepository.save(product);
        return findAll();
    }
    
    public Product findById(Long id) {
        return productRepository.findById(id)
        		.orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return findAll();
    }

    public List<Product> update(Long id, Product productNew) {
        Product productDB = findById(id);
        //Passa as propriedades atualizadas para a entidade no banco.
    	BeanUtils.copyProperties(productNew, productDB);
        productRepository.save(productDB);
		return findAll();
    }
    
    public Product findProductByCodBarras(String codBarras) {
    	return productRepository.findProductByCodBarras(codBarras)
    			.orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }
}
