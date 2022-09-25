package com.unifica.documentos.dto;

import com.unifica.documentos.entity.documents.Outros;
import com.unifica.documentos.entity.enums.TypeDocument;

public class OutrosDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private String photoDocument;
	private Integer user;
	private String nomeDocumento;
	private String dados;

	public OutrosDTO() {
	}
	
	public OutrosDTO(Outros obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
		this.photoDocument = obj.getPhotoDocument();
		this.user = obj.getUser().getId();
		this.nomeDocumento = obj.getNomeDocumento();
		this.dados = obj.getDados();
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

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	
}
