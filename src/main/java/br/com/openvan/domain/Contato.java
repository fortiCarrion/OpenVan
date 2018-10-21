package br.com.openvan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_id", nullable = false)
	private Long id;
	
	// Nome referente ao contato, exemplo: pai, mae, irmao, ...
	@Column(name = "con_referencia", nullable = false, length = 12)
	private String referencia;
	
	@Column(name = "con_celular", nullable = true, length = 16)
	private String celular;
	
	@Column(name = "con_comercial", nullable = true, length = 16)
	private String comercial;

	@Column(name = "con_residencial", nullable = true, length = 16)
	private String residencial;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "con_aluno", nullable = false)
	private Aluno aluno;
	
	
	public Contato() {
		
	}

	public Contato(Long id, String referencia, String celular, String comercial, String residencial, Aluno aluno) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.celular = celular;
		this.comercial = comercial;
		this.residencial = residencial;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getResidencial() {
		return residencial;
	}

	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", referencia=" + referencia + ", celular=" + celular + ", comercial=" + comercial
				+ ", residencial=" + residencial + ", aluno=" + aluno + "]";
	}
	
	
	
}
