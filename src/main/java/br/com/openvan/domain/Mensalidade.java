package br.com.openvan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.openvan.domain.enums.StatusPagamento;

@Entity
public class Mensalidade {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "men_id", nullable = false)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "men_emissao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date emissao;
	
	@Column(name = "men_vencimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@Column(name = "men_pagamento")
	@Temporal(TemporalType.DATE)
	private Date pagamento;
	
	@Column(name = "men_status", nullable = false, length = 12)
	private Integer status;
	
	@Column(name = "men_valor", nullable = false, precision = 4, scale = 2)
	private Double valor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "men_aluno", nullable = false)
	private Aluno aluno;
	
	public Mensalidade() {
		
		
	}

	public Mensalidade(Long id, Date emissao, Date vencimento, Date pagamento, StatusPagamento status, Double valor,
			Aluno aluno) {
		super();
		this.id = id;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.status = (status==null) ? null : status.getCodigo();
		this.valor = valor;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public StatusPagamento getStatus() {
		return StatusPagamento.toEnum(status);
	}

	public void setStatus(StatusPagamento status) {
		this.status = status.getCodigo();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
		Mensalidade other = (Mensalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensalidade [id=" + id + ", emissao=" + emissao + ", vencimento=" + vencimento + ", pagamento="
				+ pagamento + ", status=" + status + ", valor=" + valor + ", aluno=" + aluno + "]";
	}
	
	

}
