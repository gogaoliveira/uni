package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.TituloEleitor;
import com.unifica.documentos.entity.enums.TypeDocument;

public class TituloEleitorDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private String photoDocument;
	private Integer user;
	private Date dataNascimento;
	private Date dataEmissao;
	private String zona;
	private String secao;
	private String municipio;

	public TituloEleitorDTO() {
	}
	
	public TituloEleitorDTO(TituloEleitor obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.photoDocument = obj.getPhotoDocument();
		this.user = obj.getUser().getId();
		this.dataNascimento = obj.getDataNascimento();
		this.dataEmissao = obj.getDataEmissao();
		this.zona = obj.getZona();
		this.secao = obj.getSecao();
		this.municipio = obj.getMunicipio();
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

	public String getPhotoDocument() {
		return photoDocument;
	}

	public void setPhotoDocument(String photoDocument) {
		this.photoDocument = photoDocument;
	}

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
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

}
