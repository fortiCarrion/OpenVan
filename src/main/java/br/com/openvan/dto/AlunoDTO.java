package br.com.openvan.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.enums.PeriodoAluno;
import br.com.openvan.domain.enums.StatusAluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max = 50, message = "O tamanho tem que ser entre 4 a 50 caracteres")
	private String nome;

	private String pai;
	private String mae;

	//@NotEmpty(message = "Preenchimento obrigatório")
	private PeriodoAluno periodo;

	private String celular;
	private StatusAluno status;
	private String recado;

	//@NotEmpty(message = "Preenchimento obrigatório")
	private Double valor;

	//@NotEmpty(message = "Preenchimento obrigatório")
	private int vencimentoMensalidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date registro;

	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno obj) {
		id = obj.getId();
		nome = obj.getNome();
		pai = obj.getPai();
		mae = obj.getMae();
		periodo = obj.getPeriodo();
		recado = obj.getRecado();
		celular = obj.getCelular();
		status = obj.getStatus();
		valor = obj.getValor();
		vencimentoMensalidade = obj.getVencimentoMensalidade();
		registro = obj.getRegistro();
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
		return periodo;
	}

	public void setPeriodo(PeriodoAluno periodo) {
		this.periodo = periodo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public StatusAluno getStatus() {
		return status;
	}

	public void setStatus(StatusAluno status) {
		this.status = status;
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

//	public void setRegistro(Date registro) {
//		this.registro = registro;
//	}
	
	
}
