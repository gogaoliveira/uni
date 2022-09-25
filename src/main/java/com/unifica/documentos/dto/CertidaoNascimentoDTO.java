package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.CertidaoNascimento;
import com.unifica.documentos.entity.enums.TypeDocument;

public class CertidaoNascimentoDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private String photoDocument;
	private Integer user;
	private String tipo;
	private String cpf;
	private Date dataNascimento;
	private String localNascimento;
	private String sexo;
	private String filiacao;
	private String avosPaternos;
	private String avosMaternos;
	private String numeroDnv;
	private String observacao;
	private String municipioDeRegistro;
	private String naturalidade;
	
	public CertidaoNascimentoDTO() {
	}
	
	public CertidaoNascimentoDTO(CertidaoNascimento obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.photoDocument = obj.getPhotoDocument();
		this.user = obj.getUser().getId();
		this.tipo = obj.getTipo();
		this.cpf = obj.getCpf();
		this.dataNascimento = obj.getDataNascimento();
		this.localNascimento = obj.getLocalNascimento();
		this.sexo = obj.getSexo();
		this.filiacao = obj.getFiliacao();
		this.avosPaternos = obj.getAvosPaternos();
		this.avosMaternos = obj.getAvosMaternos();
		this.numeroDnv = obj.getNumeroDnv();
		this.observacao = obj.getObservacao();
		this.municipioDeRegistro = obj.getMunicipioDeRegistro();
		this.naturalidade = obj.getNaturalidade();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLocalNascimento() {
		return localNascimento;
	}

	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFiliacao() {
		return filiacao;
	}

	public void setFiliacao(String filiacao) {
		this.filiacao = filiacao;
	}

	public String getAvosPaternos() {
		return avosPaternos;
	}

	public void setAvosPaternos(String avosPaternos) {
		this.avosPaternos = avosPaternos;
	}

	public String getAvosMaternos() {
		return avosMaternos;
	}

	public void setAvosMaternos(String avosMaternos) {
		this.avosMaternos = avosMaternos;
	}

	public String getNumeroDnv() {
		return numeroDnv;
	}

	public void setNumeroDnv(String numeroDnv) {
		this.numeroDnv = numeroDnv;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getMunicipioDeRegistro() {
		return municipioDeRegistro;
	}

	public void setMunicipioDeRegistro(String municipioDeRegistro) {
		this.municipioDeRegistro = municipioDeRegistro;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

}
