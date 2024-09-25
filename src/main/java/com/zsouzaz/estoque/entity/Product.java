package com.zsouzaz.estoque.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "typeProduct")
    private String tipo;
    
    @Column(name = "markProduct")
    private String marca;
    
    @Column(name = "price")
    private Double preco;
    
    @Column(name = "barcode")
    private String codBarras;

    public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String qrCode) {
		this.codBarras = qrCode;
	}

	public Long getId() {
		return id;
	}

	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}