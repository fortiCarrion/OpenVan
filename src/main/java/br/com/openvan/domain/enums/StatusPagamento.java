package br.com.openvan.domain.enums;

public enum StatusPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	ATRASADO(3, "Atrasado"),
	CANCELADO(4, "Cancelado");
	
	private int codigo;
	private String status;
	
	private StatusPagamento(int codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public static StatusPagamento toEnum(Integer codigo) {
		
		if(codigo == null) {
			return null;
		}
		
		for(StatusPagamento x: StatusPagamento.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Idinválido " + codigo);
	}
}
