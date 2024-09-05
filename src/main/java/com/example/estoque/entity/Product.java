package com.example.estoque.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "produtos")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String marca;
    private Double preco;
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