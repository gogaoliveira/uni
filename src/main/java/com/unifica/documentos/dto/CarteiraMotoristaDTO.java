package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.CarteiraMotorista;
import com.unifica.documentos.entity.enums.TypeDocument;

public class CarteiraMotoristaDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private Date validade;
	private Date primeiraHabilitacao;
	private String categoria;
	private String observacoes;
	private String permissao;
	private String acc;
	private String privateDocument;
	
	
	public CarteiraMotoristaDTO() {
	}
	
	public CarteiraMotoristaDTO(CarteiraMotorista obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.validade = obj.getValidade();
		this.primeiraHabilitacao = obj.getPrimeiraHabilitacao();
		this.categoria = obj.getCategoria();
		this.observacoes = obj.getObservacoes();
		this.permissao = obj.getPermissao();
		this.acc = obj.getACC();
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

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public Date getPrimeiraHabilitacao() {
		return primeiraHabilitacao;
	}

	public void setPrimeiraHabilitacao(Date primeiraHabilitacao) {
		this.primeiraHabilitacao = primeiraHabilitacao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
	
	
	

}