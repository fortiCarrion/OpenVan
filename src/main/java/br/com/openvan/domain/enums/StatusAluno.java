package br.com.openvan.domain.enums;

public enum StatusAluno {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo");
	
	private int codigo;
	private String status;
	
	private StatusAluno(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static StatusAluno toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(StatusAluno x: StatusAluno.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + codigo);
	}
}
