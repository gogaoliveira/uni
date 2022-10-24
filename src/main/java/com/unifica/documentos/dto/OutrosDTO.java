package com.unifica.documentos.dto;

import com.unifica.documentos.entity.documents.Outros;
import com.unifica.documentos.entity.enums.TypeDocument;

public class OutrosDTO {
	
	private TypeDocument type;
	private String numberDocument;
	private Integer user;
	private String nomeDocumento;
	private String dados;
	private String privateDocument;

	public OutrosDTO() {
	}
	
	public OutrosDTO(Outros obj) {
		this.type = obj.getType();
		this.numberDocument = obj.getNumberDocument();
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

	public String getPrivateDocument() {
		return privateDocument;
	}

	public void setPrivateDocument(String privateDocument) {
		this.privateDocument = privateDocument;
	}

	
}