package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.Cpf;
import com.unifica.documentos.entity.enums.TypeDocument;

public class CpfDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private Date dataNascimento;
	private String privateDocument;

	public CpfDTO() {
	}
	
	public CpfDTO(Cpf obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.dataNascimento = obj.getDataNascimento();
	}

	public TypeDocument getType() {
		return type;
	}

	public void setType(TypeDocument type) {
		this.type = type;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
		

}