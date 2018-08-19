package br.com.openvan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.openvan.domain.Veiculo;

public class VeiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 50, message = "O tamanho tem que ser entre 4 a 50 caracteres")
	private String condutor;
	
	private Integer numero;
	private String modelo;
	private int ano;	
	private String status;
	
	@Length(min = 0, max = 150, message = "Campo não pode ter mais de 150 caracteres")
	private String recado;

	private Date registro;
	
	public VeiculoDTO() {
		
	}
	
	public VeiculoDTO(Veiculo obj) {
		id = obj.getId();
		condutor = obj.getCondutor();
		numero = obj.getNumero();
		modelo = obj.getModelo();
		ano = obj.getAno();
		status = obj.getStatus();
		recado = obj.getRecado();
		registro = obj.getRegistro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCondutor() {
		return condutor;
	}

	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}
	
	
	
	

}
