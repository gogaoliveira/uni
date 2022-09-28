package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class Cpf extends Document{
	private static final long serialVersionUID = 1L;
	
	private Date dataNascimento;
	private String name;
	
	public Cpf() {
	}

	public Cpf(Integer id, TypeDocument type, String numberDocument, String photoDocument, User user, Date dataNascimento) {
		super(id, type, numberDocument, photoDocument, user);
		this.dataNascimento = dataNascimento;
		this.name = "CPF";
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
