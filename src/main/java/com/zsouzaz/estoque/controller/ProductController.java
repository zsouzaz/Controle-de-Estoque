package com.zsouzaz.estoque.controller;

import org.springframework.web.bind.annotation.*;

import com.zsouzaz.estoque.entity.Product;
import com.zsouzaz.estoque.service.ProductService;

import java.util.List;

@RestController
// url onde esta API deve trabalhar.
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    // Injeção de dependências.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public List<Product> create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }
    
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
    	return productService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public List<Product> update(@PathVariable Long id, @RequestBody Product product) {
        try {
    	return productService.update(id, product);
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
        }
		return null;
    }

    @DeleteMapping(value = "/{id}")
    public List<Product> delete(@PathVariable Long id) {
        return productService.delete(id);
    }
    
    @GetMapping("/codigo-barras/{codBarras}")
    public Product findProductByCodBarras(@PathVariable String codBarras){
        return productService.findProductByCodBarras(codBarras);
    }
}
