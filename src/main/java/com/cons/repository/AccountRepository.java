package com.cons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cons.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account findByUsername(String username);
}
