package com.cons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cons.dto.AccountDto;
import com.cons.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RegistrationController {
	private final AccountService accountService;
	
	@PostMapping("/register")
	public String processRegister(@ModelAttribute AccountDto.RegistrationRequest request) {
		accountService.createAccount(request);
		log.info("user create");
		return "redirect:/";
	}
}
