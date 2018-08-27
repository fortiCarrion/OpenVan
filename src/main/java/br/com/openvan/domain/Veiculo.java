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

import br.com.openvan.domain.enums.StatusVeiculo;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vel_id", nullable = false)
	private Long id;

	@Column(name = "vel_condutor", nullable = false, length = 50)
	private String condutor;

	@Column(unique = true, name = "vel_numero", nullable = false, length = 4)
	private Integer numero;

	@Column(name = "vel_modelo", nullable = true, length = 50)
	private String modelo;

	@Column(name = "vel_ano", nullable = true, length = 4)
	private int ano;

	// status do veiculo, "ATIVO", "INATIVO", "MANUTENÇÃO", ...
	@Column(name = "vel_status", nullable = false, length = 12)
	private Integer status;

	@Column(name = "vel_recado", nullable = true, length = 150)
	private String recado;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@Column(name = "vel_registro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@OneToMany(mappedBy = "veiculo")
	private List<Aluno> alunos = new ArrayList<>();

	public Veiculo() {

	}

	public Veiculo(Long id, String condutor, Integer numero, String modelo, int ano, StatusVeiculo status, String recado,
			Date registro) {
		super();
		this.id = id;
		this.condutor = condutor;
		this.numero = numero;
		this.modelo = modelo;
		this.ano = ano;
		this.status = status.getCodigo();
		this.recado = recado;
		this.registro = registro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCondutor() {
		return condutor;
	}

	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public StatusVeiculo getStatus() {
		return StatusVeiculo.toEnum(status);
	}

	public void setStatus(StatusVeiculo status) {
		this.status = status.getCodigo();
	}

	public String getRecado() {
		return recado;
	}

	public void setRecado(String recado) {
		this.recado = recado;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", condutor=" + condutor + ", numero=" + numero + ", modelo=" + modelo + ", ano="
				+ ano + ", status=" + status + ", recado=" + recado + ", registro=" + registro + "]";
	}

}
