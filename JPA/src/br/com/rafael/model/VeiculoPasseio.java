package br.com.rafael.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo_passeio")
public abstract class VeiculoPasseio extends Veiculo implements Serializable {

	@Column(name = "qtd_pessoas", nullable = false)
	private Integer quantidadeDePessoas;

	public VeiculoPasseio() {
		super();
	}

	public Integer getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}

	public void setQuantidadeDePessoas(Integer quantidadeDePessoas) {
		this.quantidadeDePessoas = quantidadeDePessoas;
	}

}
