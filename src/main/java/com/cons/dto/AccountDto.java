package com.cons.dto;

import lombok.Getter;
import lombok.Setter;

public class AccountDto {

	@Getter
	@Setter
	public static class RegistrationRequest {
		private String username;
		private String password;
		private String role;
		
		public static RegistrationRequest with(String username, String password, String role) {
			RegistrationRequest request = new RegistrationRequest();
			request.setUsername(username);
			request.setPassword(password);
			request.setRole(role);
			return request;
		}
	}
}
