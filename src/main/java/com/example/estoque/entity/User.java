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

	// Cria uma tabela que irá fazer as relações entre users e todas as suas permissões.
	@Column(name = "permissions")
	@ManyToMany(fetch = FetchType.EAGER) // Busca as permissões junto ao usuário.
	@JoinTable(
		name = "user_permission", // nome da tabela que será gerada.
		joinColumns = @JoinColumn(name = "user_id"), // relação da tabela de usuarios.
		inverseJoinColumns = @JoinColumn(name = "permission_id")) // relação da tabela de permissões.
	private Set<Permission> permissoes = new HashSet<>();

	// Este campo dirá qual o privilégio deste usuário, no banco entende-se como uma String, mas no backend só é aceito os valores nomeados abaixo;
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
