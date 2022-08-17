package com.unifica.documentos.entity.documents;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Cpf extends Document{
	private static final long serialVersionUID = 1L;
	
	private Date dataNascimento;
	
	public Cpf() {
	}

	public Cpf(Integer id, TypeDocument type, String numberDocument, String photoDocument, User user, Date dataNascimento) {
		super(id, type, numberDocument, photoDocument, user);
		this.dataNascimento = dataNascimento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
