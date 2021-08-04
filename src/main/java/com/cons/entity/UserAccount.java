package com.cons.entity;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class UserAccount extends User {
	
	private Account account;
	
	public UserAccount(Account account) {
		super(account.getUsername(), account.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_"+account.getRole())));
		this.account = account;
	}
}
