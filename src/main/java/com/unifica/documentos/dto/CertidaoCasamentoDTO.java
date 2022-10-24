package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.CertidaoCasamento;
import com.unifica.documentos.entity.enums.TypeDocument;

public class CertidaoCasamentoDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private String nomeConjuge;
	private String cpfConjuge;
	private Date nascimentoConjuge;
	private String cidadeNascimentoConjuge;
	private String paiConjunge;
	private String maeConjuge;
	private Date dataCasamento;
	private String regimeBens;
	private String observacoes;
	private String privateDocument;
	
	public CertidaoCasamentoDTO() {
	}
	
	public CertidaoCasamentoDTO(CertidaoCasamento obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.cpfConjuge = obj.getCpfConjuge();
		this.nascimentoConjuge = obj.getNascimentoConjuge();
		this.cidadeNascimentoConjuge = obj.getCidadeNascimentoConjuge();
		this.paiConjunge = obj.getPaiConjunge();
		this.maeConjuge = obj.getMaeConjuge();
		this.dataCasamento = obj.getDataCasamento();
		this.regimeBens = obj.getRegimeBens();
		this.observacoes = obj.getObservacoes();
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

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public String getCpfConjuge() {
		return cpfConjuge;
	}

	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}

	public Date getNascimentoConjuge() {
		return nascimentoConjuge;
	}

	public void setNascimentoConjuge(Date nascimentoConjuge) {
		this.nascimentoConjuge = nascimentoConjuge;
	}

	public String getCidadeNascimentoConjuge() {
		return cidadeNascimentoConjuge;
	}

	public void setCidadeNascimentoConjuge(String cidadeNascimentoConjuge) {
		this.cidadeNascimentoConjuge = cidadeNascimentoConjuge;
	}

	public String getPaiConjunge() {
		return paiConjunge;
	}

	public void setPaiConjunge(String paiConjunge) {
		this.paiConjunge = paiConjunge;
	}

	public String getMaeConjuge() {
		return maeConjuge;
	}

	public void setMaeConjuge(String maeConjuge) {
		this.maeConjuge = maeConjuge;
	}

	public Date getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(Date dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public String getRegimeBens() {
		return regimeBens;
	}

	public void setRegimeBens(String regimeBens) {
		this.regimeBens = regimeBens;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
	
	

}