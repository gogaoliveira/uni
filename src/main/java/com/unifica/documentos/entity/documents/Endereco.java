package com.unifica.documentos.entity.documents;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class Endereco extends Document{
	private static final long serialVersionUID = 1L;
	
	private String Endereco;
	private String complemento;
	private String cep;
	private String numero;
	private String cidade;
	private String uf;	
	
	public Endereco() {
	}

	public Endereco(
			Integer id, 
			TypeDocument type,
			String numberDocument, 
			String photoDocument, 
			User user,
			String Endereco,
			String complemento,
			String cep,
			String numero,
			String cidade,
			String uf) {
		super(id, type, numberDocument, photoDocument, user);
		this.Endereco = Endereco;
		this.complemento = complemento;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.uf = uf;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
