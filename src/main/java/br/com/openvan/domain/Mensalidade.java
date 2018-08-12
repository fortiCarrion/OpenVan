package br.com.openvan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Mensalidade {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menid", nullable = false)
	private Long id;
	
	@Column(name = "menemissao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date emissao;
	
	@Column(name = "menvencimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@Column(name = "menpagamento")
	@Temporal(TemporalType.DATE)
	private Date pagamento;
	
	@Column(name = "menstatus", nullable = false, length = 12)
	private String status;
	
	@Column(name = "menvalor", nullable = false, precision = 4, scale = 2)
	private float valor;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "menaluno")
	private Aluno aluno;
	
	public Mensalidade() {
		
		
	}

	public Mensalidade(Long id, Date emissao, Date vencimento, Date pagamento, String status, float valor,
			Aluno aluno) {
		super();
		this.id = id;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.pagamento = pagamento;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
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
