package com.cons.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cons.domain.Account;
import com.cons.domainservice.CreateAccountService;
import com.cons.dto.AccountDto;
import com.cons.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;
	private final CreateAccountService createAccountService;
	
	@Transactional
	public void createAccount(AccountDto.RegistrationRequest request) {
		Account curAccount = createAccountService.createAccount(request.getUsername(), request.getPassword(), request.getRole());
		accountRepository.save(curAccount);
	}
}
