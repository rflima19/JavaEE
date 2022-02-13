package br.com.rafael.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "voo")
@IdClass(VooPK.class)
public class Voo {

	@Id
	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Id
	@Column(name = "empresa", nullable = false, length = 30)
	private String empresa;

	@Column(name = "origem", nullable = false, length = 60)
	private String origem;

	@Column(name = "destino", nullable = false, length = 60)
	private String destino;

	public Voo() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Voo [numero=" + numero + ", empresa=" + empresa + ", origem=" + origem + ", destino=" + destino + "]";
	}
}
