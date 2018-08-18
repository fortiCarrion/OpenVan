package br.com.openvan.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.openvan.domain.Colegio;

public class ColegioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Integer rede;
	private String nome;
	private String endereco;
	private int numero;
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
