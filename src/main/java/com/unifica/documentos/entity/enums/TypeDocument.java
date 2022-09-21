package com.unifica.documentos.entity.enums;

public enum TypeDocument {
	
	CARTEIRA_MOTORISTA(1, "Carteira de Motorista"),
	CARTEIRA_TRABALHO(2, "Carteira de Trabalho"),
	CERTIDAO_CASAMENTO(3, "Certidão de Casamento"),
	CERTIDAO_NASCIMENTO(4, "Certidão de Nascimento"),
	CPF(5, "CPF"),
	ENDERECO(6, "Endereço"),
	OUTROS(7, "Outros"),
	RG(8, "RG"),
	TITULO_ELEITOR(9, "Titulo de Eleitor");
	
	
	private int cod;
	private String description;
	
	private TypeDocument(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeDocument toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (TypeDocument x : TypeDocument.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: " + cod);
	}
	
	

}
