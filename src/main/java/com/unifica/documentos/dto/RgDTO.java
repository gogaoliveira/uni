package com.unifica.documentos.dto;

import java.util.Date;

import com.unifica.documentos.entity.documents.Rg;
import com.unifica.documentos.entity.enums.TypeDocument;

public class RgDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private Date dataExpedicao;
	private Date dataNascimento;
	private String naturalidade;
	private String nomeMae;
	private String nomePai;
	private String orgaoExpedidor;
	private String privateDocument;

	public RgDTO() {
	}
	
	public RgDTO(Rg obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.dataExpedicao = obj.getDataExpedicao();
		this.dataNascimento = obj.getDataNascimento();
		this.naturalidade = obj.getNaturalidade();
		this.nomeMae = obj.getNomeMae();
		this.nomePai = obj.getNomePai();
		this.orgaoExpedidor = obj.getOrgaoExpedidor();
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

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
}