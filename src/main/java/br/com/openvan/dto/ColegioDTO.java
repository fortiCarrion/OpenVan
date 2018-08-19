package br.com.openvan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.openvan.domain.Colegio;

public class ColegioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	//@NotEmpty(message = "Preenchimento obrigatório")
	//@Length(min = 1, max = 15, message = "O compra tem que ser entre 1 a 15 caracteres")
	private Integer rede;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 50, message = "O tamanho tem que ser entre 4 a 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 50, message = "O tamanho tem que ser entre 4 a 50 caracteres")
	private String endereco;
	
	//@NotEmpty(message = "Preenchimento obrigatório")
	//@Length(min = 1, max = 4, message = "O tamanho tem que ser entre 1 a 4 caracteres")
	private Integer numero;
	
	@Length(max = 15, message = "Limete de tamanho 15 excedido")
	private String telefone;
	private String website;
	private Date registro;
	
	public ColegioDTO() {
		
	}
	
	public ColegioDTO(Colegio obj) {
		id = obj.getId();
		rede = obj.getRede();
		nome = obj.getNome();
		endereco = obj.getEndereco();
		numero = obj.getNumero();
		telefone = obj.getTelefone();
		website = obj.getWebsite();
		registro = obj.getRegistro();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRede() {
		return rede;
	}

	public void setRede(Integer rede) {
		this.rede = rede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}
}
