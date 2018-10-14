package br.com.openvan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.openvan.domain.enums.RedeColegio;
import br.com.openvan.domain.enums.StatusVeiculo;

@Entity
public class Colegio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clg_id", nullable = false)
	private Long id;

	// Indentificar se a escola eh de rede publica, privada, ...
	@Column(name = "clg_rede", nullable = false, length = 12)
	private Integer rede;

	@Column(unique = true, name = "clg_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "clg_endereco", nullable = false, length = 50)
	private String endereco;

	@Column(name = "clg_numero", nullable = false, length = 5)
	private Integer numero;

	@Column(name = "clg_telefone", nullable = true, length = 15)
	private String telefone;

	@Column(name = "clg_website", nullable = true, length = 100)
	private String website;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "clg_dataregistro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@OneToMany(mappedBy = "colegio")
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Colegio() {

	}

	public Colegio(Long id, Integer rede, String nome, String endereco, Integer numero, String telefone, String website,
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

	public RedeColegio getRede() {
		return RedeColegio.toEnum(rede);
	}

	public void setRede(RedeColegio rede) {
		this.rede = rede.getCodigo();
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

	public void setNumero(Integer numero) {
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
/*
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
*/
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
