package br.com.openvan.domain.enums;

public enum RedeColegio {

	PARTICULAR(1, "Particular"), 
	ESTADUAL(2, "Estadual"), 
	MUNICIPAL(3, "Municipal");

	private Integer codigo;
	private String status;

	private RedeColegio(Integer codigo, String status) {
		this.codigo = codigo;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getStatus() {
		return status;
	}

	public static RedeColegio toEnum(Integer codigo) {

		if (codigo == null) {
			return null;
		}

		for (RedeColegio x : RedeColegio.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido " + codigo);
	}

}
