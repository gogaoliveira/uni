package com.unifica.documentos.entity.documents;

import javax.persistence.Entity;

import com.unifica.documentos.entity.Document;
import com.unifica.documentos.entity.User;
import com.unifica.documentos.entity.enums.TypeDocument;

@Entity
public class CarteiraTrabalho extends Document{
	private static final long serialVersionUID = 1L;
	
	private String pis;
	private String serie;
	private String uf;
	
	
	public CarteiraTrabalho() {
	}

	public CarteiraTrabalho(
			Integer id, 
			TypeDocument type,
			String numberDocument, 
			String photoDocument, 
			User user,
			String pis,
			String serie,
			String uf) {
		super(id, type, numberDocument, photoDocument, user);
		this.pis = pis;
		this.serie = serie;
		this.uf = uf;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
