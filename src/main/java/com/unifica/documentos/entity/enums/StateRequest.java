package com.unifica.documentos.entity.enums;

public enum StateRequest {
	
	APPROVED(1, "Aproved"),
	REFUSED(2, "Refused"),
	AWAIT(3, "Await");
	
	private int cod;
	private String description;
	
	private StateRequest(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static StateRequest toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (StateRequest x : StateRequest.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid id: " + cod);
	}
	
	

}
