package com.example.estoque.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "UsersAdmin")
@Builder
public class UserAdmin extends User {
	
}
