package com.cons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Getter;

@Entity
@Getter
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	private String role;
	
	private void setUsername(String username) {
		this.username = username;
	}
	
	private void setPassword(String password) {
		this.password = password;
	}
	
	private void setRole(String role) {
		this.role = role;
	}
	
	public static Account with(String username, String encryptedPassword, String role) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(encryptedPassword);
		account.setRole(role);
		return account;
	}
}
