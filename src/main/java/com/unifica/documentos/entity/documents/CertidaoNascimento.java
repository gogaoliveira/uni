package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class CertidaoNascimento extends Document{
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private String cpf;
	private Date dataNascimento;
	private String Naturalidade;
	private String MunicipioDeRegistro;
	private String localNascimento;
	private String sexo;
	private String filiacao;
	private String avos;
	private String numeroDnv;
	private String observacao;
	
	public CertidaoNascimento() {
	}

	public CertidaoNascimento(
			Integer id, 
			TypeDocument type, 
			String numberDocument, 
			String photoDocument, 
			User user, 
			String tipo,
			String cpf,
			Date dataNascimento,
			String Naturalidade,
			String MunicipioDeRegistro,
			String localNascimento,
			String sexo,
			String filiacao,
			String avos,
			String numeroDnv,
			String observacao) {
		super(id, type, numberDocument, photoDocument, user);
		this.setTipo(tipo);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.Naturalidade = Naturalidade;
		this.MunicipioDeRegistro = MunicipioDeRegistro;
		this.localNascimento = localNascimento;
		this.sexo = sexo;
		this.filiacao = filiacao;
		this.avos = avos;
		this.observacao = observacao;
		this.numeroDnv = numeroDnv;	
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

	public String getNaturalidade() {
		return Naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		Naturalidade = naturalidade;
	}

	public String getMunicipioDeRegistro() {
		return MunicipioDeRegistro;
	}

	public void setMunicipioDeRegistro(String municipioDeRegistro) {
		MunicipioDeRegistro = municipioDeRegistro;
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

	public String getAvos() {
		return avos;
	}

	public void setAvos(String avos) {
		this.avos = avos;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	

}
