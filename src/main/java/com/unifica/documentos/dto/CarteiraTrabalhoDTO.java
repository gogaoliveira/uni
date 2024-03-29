package com.unifica.documentos.dto;

import com.unifica.documentos.entity.documents.CarteiraTrabalho;
import com.unifica.documentos.entity.enums.TypeDocument;

public class CarteiraTrabalhoDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private String pis;
	private String serie;
	private String uf;
	private String privateDocument;
	
	public CarteiraTrabalhoDTO() {
	}
	
	public CarteiraTrabalhoDTO(CarteiraTrabalho obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.user = obj.getUser().getId();
		this.pis = obj.getPis();
		this.serie = obj.getSerie();
		this.uf = obj.getUf();
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

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}
	
	


}