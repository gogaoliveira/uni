package com.unifica.documentos.dto;

import com.unifica.documentos.entity.documents.Endereco;
import com.unifica.documentos.entity.enums.TypeDocument;

public class EnderecoDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private String complemento;
	private String cep;
	private String numero;
	private String cidade;
	private String uf;
	private String endereco;
	private String privateDocument;

	public EnderecoDTO() {
	}
	
	public EnderecoDTO(Endereco obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.complemento = obj.getComplemento();
		this.cep = obj.getCep();
		this.numero = obj.getNumero();
		this.cidade = obj.getCidade();
		this.uf = obj.getUf();
		this.endereco = obj.getEndereco();
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

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
	
}