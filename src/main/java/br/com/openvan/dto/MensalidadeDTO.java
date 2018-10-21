package br.com.openvan.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.openvan.domain.Aluno;
import br.com.openvan.domain.Mensalidade;
import br.com.openvan.domain.enums.StatusPagamento;

public class MensalidadeDTO {

	private static final long serialVersionUID = 1L;
	
	private long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date emissao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date pagamento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date vencimento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date cancelamento;
	
	private StatusPagamento status;
	
	private Double valor;
	
	private Aluno aluno;
	
	public MensalidadeDTO() {
		
	}
	
	public MensalidadeDTO(Mensalidade obj) {
	id = obj.getId();
	emissao = obj.getEmissao();
	pagamento = obj.getPagamento();
	cancelamento = obj.getCancelamento();
	vencimento = obj.getVencimento();
	status = obj.getStatus();
	valor = obj.getValor();
	aluno = obj.getAluno();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public Date getCancelamento() {
		return cancelamento;
	}

	public void setCancelamento(Date cancelamento) {
		this.cancelamento = cancelamento;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
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
	
}
