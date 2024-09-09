package com.example.estoque.entity;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "Users")
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "key")
	private String senha;
	
	@Column(name = "permissions")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_permission",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissoes = new HashSet<>();
	
	@Column(name = "users_privilege")
	private Role privilegio;
	
	public enum Role {
	    USER, ADMIN;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(Role privilegio) {
		this.privilegio = privilegio;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
}
