package com.zsouzaz.estoque.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
// Esta entidade armazena as funcionalidades do sistema que poderá ser atribuídas aos usuários para que possam ser executadas.
public class Permission {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// campo que dirá qual permissão está sendo atribuída para o usuário.
	// Ex: create, update, find, delete. Cada funcionalidade do sistema será um objeto desta entidade.
	@Column(name = "permission_name")
	private String nomePermissao;

	public Permission() {}

	public String getNamePermission() {
		return nomePermissao;
	}

	public void setNamePermission(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}
}
