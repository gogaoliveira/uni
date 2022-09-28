package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class CertidaoCasamento extends Document{
	private static final long serialVersionUID = 1L;
	
	private String nomeConjuge;
	private String cpfConjuge;
	private Date nascimentoConjuge;
	private String cidadeNascimentoConjuge;
	private String paiConjunge;
	private String maeConjuge;
	private Date dataCasamento;
	private String regimeBens;
	private String observacoes;
	private String name; 
	
	public CertidaoCasamento() {
	}

	public CertidaoCasamento(
			Integer id, 
			TypeDocument type, 
			String numberDocument, 
			String photoDocument, 
			User user, 
			String nomeConjuge,
			String cpfConjuge,
			Date nascimentoConjuge,
			String cidadeNascimentoConjuge,
			String paiConjunge,
			String maeConjuge,
			Date dataCasamento,
			String regimeBens,
			String observacoes) {
		super(id, type, numberDocument, photoDocument, user);
		this.nomeConjuge = nomeConjuge;
		this.cpfConjuge = cpfConjuge;
		this.nascimentoConjuge = nascimentoConjuge;
		this.cidadeNascimentoConjuge = cidadeNascimentoConjuge;
		this.paiConjunge = paiConjunge;
		this.maeConjuge = maeConjuge;
		this.dataCasamento = dataCasamento;
		this.regimeBens = regimeBens;
		this.observacoes = observacoes;
		this.name = "Certidão de Casamento";
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
