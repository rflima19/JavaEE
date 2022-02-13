package br.com.rafael.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carro")
//@DiscriminatorValue("2")
public class Carro extends VeiculoPasseio implements Serializable {

//	@Column(name = "qtd_portas", nullable = false)
	@Column(name = "qtd_portas")
	private Integer quantidadeDePortas;

	public Carro() {
		super();
	}

	public Integer getQuantidadeDePortas() {
		return quantidadeDePortas;
	}

	public void setQuantidadeDePortas(Integer quantidadeDePortas) {
		this.quantidadeDePortas = quantidadeDePortas;
	}

}
