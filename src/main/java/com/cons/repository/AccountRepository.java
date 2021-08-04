package com.cons.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cons.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
