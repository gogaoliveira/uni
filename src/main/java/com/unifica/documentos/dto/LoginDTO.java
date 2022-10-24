package com.unifica.documentos.dto;

import com.unifica.documentos.entity.User;

public class LoginDTO {
	
	private String email;
	private String password;
	
	public LoginDTO() {
	}
	
	public LoginDTO(User obj) {
		email = obj.getEmail();
		password = obj.getPassword();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}