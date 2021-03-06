package br.com.model.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable{

	private static final long serialVersionUID = 1L;

	private VeiculoId codigo;
	private String fabricante;
	private String modelo;
	private Proprietario proprietario;
	
	public Veiculo() {
	}
	
	@EmbeddedId
	public VeiculoId getCodigo() {
		return codigo;
	}
	public void setCodigo(VeiculoId codigo) {
		this.codigo = codigo;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Transient
	public String getDescricao() {
		return "Veiculo [codigo=" + codigo.getCidade() + " - " + codigo.getPlaca() + ", fabricante=" + fabricante
				+ ", modelo=" + modelo + ", proprietario=" + proprietario + "]";
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
