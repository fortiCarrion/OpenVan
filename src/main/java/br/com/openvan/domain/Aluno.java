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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alnid", nullable = false)
	private Long id;

	@Column(name = "alnnome", nullable = false, length = 50)
	private String nome;

	@Column(name = "alnpai", nullable = false, length = 50)
	private String pai;

	@Column(name = "alnmae", nullable = false, length = 50)
	private String mae;

	// periodo : noturno, matutino, vespertino.
	@Column(name = "alnperiodo", nullable = false, length = 12)
	private String periodo;

	@Column(name = "alncelular", nullable = true, length = 16)
	private String celular;

	@Column(name = "alnstatus", nullable = false, length = 12)
	private String status;

	@Column(name = "alnrecado", nullable = true, length = 150)
	private String recado;

	@Column(name = "alnvalor", nullable = false, precision = 4, scale = 2)
	private float valor;

	@Column(name = "alnvencimento", nullable = false)
	private int vencimentoMensalidade;

	@Column(name = "alnregistro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@ManyToOne
	@JoinColumn(name = "alncolegio")
	private Colegio colegio;
	
	@ManyToOne
	@JoinColumn(name = "alnveiculo")
	private Veiculo veiculo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "aluno")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "aluno")
	private List<Contato> contatos = new ArrayList<>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "aluno")
	private List<Mensalidade> mensalidades = new ArrayList<>();

	public Aluno() {

	}

	public Aluno(Long id, String nome, String pai, String mae, String periodo, String celular, String status,
			String recado, float valor, int vencimentoMensalidade, Date registro, Colegio colegio, Veiculo veiculo) {
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
		this.colegio = colegio;
		this.veiculo = veiculo;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getVencimentoMensalidade() {
		return vencimentoMensalidade;
	}

	public void setVencimentoMensalidade(int vencimentoMensalidade) {
		this.vencimentoMensalidade = vencimentoMensalidade;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
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
