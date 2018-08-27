package br.com.openvan.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.openvan.domain.Colegio;
import br.com.openvan.domain.Contato;
import br.com.openvan.domain.Endereco;
import br.com.openvan.domain.Veiculo;

public class AlunoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// Aluno
	private String nome;
	private String pai;
	private String mae;
	private Integer periodo;
	private String celular;
	private Integer status;
	private String recado;
	private Double valor;
	private int vencimentoMensalidade;
	private Date registro;
	
	private Colegio colegio;
	
	private Veiculo veiculo;
	
	// Endereço
	private List<Endereco> enderecos = new ArrayList<>();
//	private String endereco;
//	private int numero;
//	private String bairro;
//	private String complemento;
//	
	// Contato
	private List<Contato> contatos = new ArrayList<>();
//	private String referencia;
//	private String celular_contato;
//	private String comercial;
//	private String residencial;

	
	public AlunoNewDTO() {

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

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Colegio getColegio() {
		return colegio;
	}

	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getRegistro() {
		return registro;
	}

//	public void setRegistro(Date registro) {
//		this.registro = registro;
//	}

//	public String getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(String endereco) {
//		this.endereco = endereco;
//	}
//
//	public int getNumero() {
//		return numero;
//	}
//
//	public void setNumero(int numero) {
//		this.numero = numero;
//	}
//
//	public String getBairro() {
//		return bairro;
//	}
//
//	public void setBairro(String bairro) {
//		this.bairro = bairro;
//	}
//	
//	public String getComplemento() {
//		return complemento;
//	}
//
//	public void setComplemento(String complemento) {
//		this.complemento = complemento;
//	}
//
//	public String getReferencia() {
//		return referencia;
//	}
//
//	public void setReferencia(String referencia) {
//		this.referencia = referencia;
//	}
//
//	public String getCelular_contato() {
//		return celular_contato;
//	}
//
//	public void setCelular_contato(String celular_contato) {
//		this.celular_contato = celular_contato;
//	}
//
//	public String getComercial() {
//		return comercial;
//	}
//
//	public void setComercial(String comercial) {
//		this.comercial = comercial;
//	}
//
//	public String getResidencial() {
//		return residencial;
//	}
//
//	public void setResidencial(String residencial) {
//		this.residencial = residencial;
//	}

	

}
