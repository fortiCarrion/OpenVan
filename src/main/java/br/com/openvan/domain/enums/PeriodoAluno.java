package br.com.openvan.domain.enums;

public enum PeriodoAluno {

	MATUTINO(1, "Matutino"),
	VESPERTINO(2, "Vespertino"),
	NOTURNO(3, "Noturno");
	
	private int codigo;
	private String status;
	
	private PeriodoAluno(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static PeriodoAluno toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(PeriodoAluno x: PeriodoAluno.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + codigo);
	}
}
