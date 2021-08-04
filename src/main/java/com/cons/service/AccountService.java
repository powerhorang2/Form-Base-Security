package com.cons.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cons.domainservice.CreateAccountService;
import com.cons.dto.AccountDto;
import com.cons.entity.Account;
import com.cons.entity.UserAccount;
import com.cons.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {
	
	private final AccountRepository accountRepository;
	private final CreateAccountService createAccountService;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserAccount(account);
	}
	
	@Transactional
	public void createAccount(AccountDto.RegistrationRequest request) {
		Account curAccount = createAccountService.createAccount(request.getUsername(), request.getPassword(), request.getRole());
		accountRepository.save(curAccount);
	}
}
