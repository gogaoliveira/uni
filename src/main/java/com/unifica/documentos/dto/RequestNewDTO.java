package com.unifica.documentos.dto;

import java.io.Serializable;

public class RequestNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String email;
	private Integer company;
	
	public RequestNewDTO() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCompany() {
		return company;
	}

	public void setCompany(Integer company) {
		this.company = company;
	}
	
}