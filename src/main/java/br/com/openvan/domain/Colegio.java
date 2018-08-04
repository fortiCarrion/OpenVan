package br.com.openvan.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Colegio implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clgid", nullable = false)
	private Long id;
	

	// Indentificar se a escola eh de rede publica, privada, ...
	@Column(name = "clgrede", nullable = false, length = 12)
	private String rede;
	
	@Column(name = "clgnome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "clgendereco", nullable = false, length = 50)
	private String endereco;
	
	@Column(name = "clgnumero", nullable = false, length = 5)
	private int numero;
	
	@Column(name = "clgtelefone", nullable = true, length = 12)
	private String telefone;
	
	@Column(name = "clgwebsite", nullable = true, length = 50)
	private String website;
	
	@Column(name = "clgdataregistro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registro;
	
	public Colegio() {
		
	}
	

	public Colegio(Long id, String rede, String nome, String endereco, int numero, String telefone, String website,
			Date registro) {
		super();
		this.id = id;
		this.rede = rede;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.telefone = telefone;
		this.website = website;
		this.registro = registro;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRede() {
		return rede;
	}

	public void setRede(String rede) {
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

	public void setNumero(short numero) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colegio other = (Colegio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Colegio [id=" + id + ", rede=" + rede + ", nome=" + nome + ", endereco=" + endereco + ", numero="
				+ numero + ", telefone=" + telefone + ", website=" + website + ", registro=" + registro + "]";
	}
	
}


