package br.com.rafael.model;

import java.io.Serializable;

public class VooPK implements Serializable {

	private Integer numero;

	private String empresa;

	public VooPK() {
		super();
	}

	public VooPK(Integer numero, String empresa) {
		super();
		this.numero = numero;
		this.empresa = empresa;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getEmpresa() {
		return empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		VooPK other = (VooPK) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
