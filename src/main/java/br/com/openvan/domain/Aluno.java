package br.com.openvan.domain;

import java.io.Serializable;
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

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alnid", nullable = false)
	private Long id;

	// FK COLEGIO

	// FK VEICULO

	@Column(name = "alnnome", nullable = false, length = 50)
	private String nome;

	@Column(name = "alnpai", nullable = false, length = 50)
	private String pai;

	@Column(name = "alnmae", nullable = false, length = 50)
	private String mae;

	// periodo : noturno, matutino, vespertino.
	@Column(name = "alnperiodo", nullable = false, length = 12)
	private String periodo;

	@Column(name = "alncelular", nullable = true, length = 12)
	private String celular;

	@Column(name = "alnstatus", nullable = false, length = 12)
	private String status;

	@Column(name = "alnrecado", nullable = true, length = 150)
	private String recado;

	@Column(name = "alnvalor", nullable = false, precision = 4, scale = 2)
	private Integer valor;

	@Column(name = "alnvencimento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimentoMensalidade;

	@Column(name = "alnregistro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registro;
	
	@ManyToOne
	@JoinColumn(name = "alncolegio")
	private Colegio colegio;
	
	@ManyToOne
	@JoinColumn(name = "alnveiculo")
	private Veiculo veiculo;

	public Aluno() {

	}

	public Aluno(Long id, String nome, String pai, String mae, String periodo, String celular, String status,
			String recado, Integer valor, Date vencimentoMensalidade, Date registro) {
		super();
		this.id = id;
		this.nome = nome;
		this.pai = pai;
		this.mae = mae;
		this.periodo = periodo;
		this.celular = celular;
		this.status = status;
		this.recado = recado;
		this.valor = valor;
		this.vencimentoMensalidade = vencimentoMensalidade;
		this.registro = registro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Date getVencimentoMensalidade() {
		return vencimentoMensalidade;
	}

	public void setVencimentoMensalidade(Date vencimentoMensalidade) {
		this.vencimentoMensalidade = vencimentoMensalidade;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", pai=" + pai + ", mae=" + mae + ", periodo=" + periodo
				+ ", celular=" + celular + ", status=" + status + ", recado=" + recado + ", valor=" + valor
				+ ", vencimentoMensalidade=" + vencimentoMensalidade + ", registro=" + registro + "]";
	}

}
