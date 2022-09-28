package com.unifica.documentos.entity.documents;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class Outros extends Document{
	private static final long serialVersionUID = 1L;
	
	private String nomeDocumento;
	private String dados;
	private String name;
	
	public Outros() {
	}

	public Outros(Integer id, TypeDocument type, String numberDocument, String photoDocument, User user, String nomeDocumento,  String dados) {
		super(id, type, numberDocument, photoDocument, user);
		this.nomeDocumento = nomeDocumento;
		this.dados = dados;
		this.name = "Outros";
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
