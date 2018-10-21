package br.com.openvan.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.openvan.domain.enums.PeriodoAluno;
import br.com.openvan.domain.enums.StatusAluno;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aln_id", nullable = false)
	private Long id;

	@Column(name = "aln_nome", nullable = false, length = 50)
	private String nome;

	@Column(name = "aln_pai", nullable = false, length = 50)
	private String pai;

	@Column(name = "aln_mae", nullable = false, length = 50)
	private String mae;

	// periodo : noturno, matutino, vespertino.
	@Column(name = "aln_periodo", nullable = false, length = 12)
	private Integer periodo;

	@Column(name = "aln_celular", nullable = true, length = 16)
	private String celular;

	@Column(name = "aln_status", nullable = false, length = 12)
	private Integer status;

	@Column(name = "aln_recado", nullable = true, length = 150)
	private String recado;

	@Column(name = "aln_valor", nullable = false, precision = 4, scale = 2)
	private Double valor;

	@Column(name = "aln_vencimento", nullable = false)
	private int vencimentoMensalidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "aln_registro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@ManyToOne
	//@JoinTable(name = "colegio",
	//	joinColumns = @JoinColumn(name = "aln_colegio"),
	//	inverseJoinColumns = @JoinColumn(name = "col_id")
	//)
	@JoinColumn(name = "aln_colegio", nullable = false)
	private Colegio colegio;
	
	@ManyToOne
	//@JoinTable(name = "veiculo",
	//	joinColumns = @JoinColumn(name = "aln_veiculo", nullable = false),
	//	inverseJoinColumns = @JoinColumn(name = "vel_id")
	//)
	@JoinColumn(name = "aln_veiculo", nullable = false)
	private Veiculo veiculo;
	
	@OneToMany(mappedBy = "aluno")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "aluno")
	private List<Contato> contatos = new ArrayList<>();
	
	@OneToMany(mappedBy = "aluno")
	private List<Mensalidade> mensalidades = new ArrayList<>();

	public Aluno() {

	}

	public Aluno(Long id, String nome, String pai, String mae, PeriodoAluno periodo, String celular, StatusAluno status,
			String recado, Double valor, int vencimentoMensalidade, Date registro, Colegio colegio, Veiculo veiculo) {
		super();
		this.id = id;
		this.nome = nome;
		this.pai = pai;
		this.mae = mae;
		this.periodo = periodo.getCodigo();
		this.celular = celular;
		this.status = status.getCodigo();
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

	public PeriodoAluno getPeriodo() {
		return PeriodoAluno.toEnum(periodo);
	}

	public void setPeriodo(PeriodoAluno periodo) {
		this.periodo = periodo.getCodigo();
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public StatusAluno getStatus() {
		return StatusAluno.toEnum(status);
	}

	public void setStatus(StatusAluno status) {
		this.status = status.getCodigo();
	}

	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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
	
	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}
	
	public Colegio getColegio() {
		return colegio;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
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
