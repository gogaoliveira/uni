package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class TituloEleitor extends Document{
	private static final long serialVersionUID = 1L;
	
	private Date dataNascimento;
	private Date dataEmissao;
	private String zona;
	private String secao;
	private String municipio;
	private String name;
	
	public TituloEleitor() {
	}

	public TituloEleitor(
			Integer id, 
			TypeDocument type,
			String numberDocument, 
			String photoDocument, 
			User user, 
			Date dataNascimento,
			Date dataEmissao,
			String zona,
			String secao,
			String municipio) {
		super(id, type, numberDocument, photoDocument, user);
		this.dataNascimento = dataNascimento;
		this.dataEmissao = dataEmissao;
		this.zona = zona;
		this.secao = secao;
		this.municipio = municipio;
		this.name = "Título de Eleitor";
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
