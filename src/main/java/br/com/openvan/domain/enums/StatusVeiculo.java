package br.com.openvan.domain.enums;

public enum StatusVeiculo {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	MANUTENÇÃO(3, "Manutenção");
	
	private int codigo;
	private String status;
	

	private StatusVeiculo(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static StatusVeiculo toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(StatusVeiculo x: StatusVeiculo.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Idinválido " + codigo);
	}

	
}
