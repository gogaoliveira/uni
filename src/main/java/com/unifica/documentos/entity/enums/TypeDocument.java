package com.unifica.documentos.entity.enums;

public enum TypeDocument {
	
	CPF(1, "CPF"),
	TITULO_ELEITOR(2, "Titulo de Eleitor");
	
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
