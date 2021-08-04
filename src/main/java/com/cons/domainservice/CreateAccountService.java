package com.cons.domainservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cons.entity.Account;

@Component
public class CreateAccountService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Account createAccount(String username, String purePassword, String role) {
		return Account.with(username, passwordEncoder.encode(purePassword), role);
	}
}
