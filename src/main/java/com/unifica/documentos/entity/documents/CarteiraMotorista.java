package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class CarteiraMotorista extends Document {
	private static final long serialVersionUID = 1L;

	private Date validade;
	private Date primeiraHabilitacao;
	private String categoria;
	private String observacoes;
	private String permissao;
	private String ACC;
	private String name;

	public CarteiraMotorista() {
	}

	public CarteiraMotorista(Integer id, TypeDocument type, String numberDocument, User user, String privateDocument, Date validade,
			Date primeiraHabilitacao, String categoria, String permissao, String ACC, String observacoes) {
		super(id, type, numberDocument, user, privateDocument);
		this.validade = validade;
		this.primeiraHabilitacao = primeiraHabilitacao;
		this.categoria = categoria;
		this.permissao = permissao;
		this.ACC = ACC;
		this.observacoes = observacoes;
		this.name = "Carteira de Motorista";
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

	public String getACC() {
		return ACC;
	}

	public void setACC(String aCC) {
		ACC = aCC;
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
