package com.acmestore.domain.enuns;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(TipoCliente tcliente : TipoCliente.values()) {
			if(cod.equals(tcliente.getCod())) {
				return tcliente;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " +cod);
	}
	
}
