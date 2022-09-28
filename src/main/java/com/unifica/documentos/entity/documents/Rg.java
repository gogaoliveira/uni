package com.unifica.documentos.entity.documents;

import java.util.Date;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class Rg extends Document {
	private static final long serialVersionUID = 1L;
	
	private Date dataExpedicao;
	private Date dataNascimento;
	private String naturalidade;
	private String nomeMae;
	private String nomePai;
	private String OrgaoExpedidor;
	private String name;

	public Rg() {
	}

	public Rg(Integer id, TypeDocument type, String numberDocument, String photoDocument, User user, Date dataExpedicao,
			Date dataNascimento, String naturalidade, String nomeMae, String nomePai, String OrgaoExpedidor) {
		super(id, type, numberDocument, photoDocument, user);
		this.dataExpedicao = dataExpedicao;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.OrgaoExpedidor = OrgaoExpedidor;
		this.name = "RG";
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
		return OrgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		OrgaoExpedidor = orgaoExpedidor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
