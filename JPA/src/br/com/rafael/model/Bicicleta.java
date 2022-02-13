package br.com.rafael.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bicicleta")
//@DiscriminatorValue("1")
public class Bicicleta extends VeiculoPasseio implements Serializable {

//	@Column(name = "tamanho_aro", nullable = false)
	@Column(name = "tamanho_aro")
	private Integer tamanhoAro;

	public Bicicleta() {
		super();
	}

	public Integer getTamanhoAro() {
		return tamanhoAro;
	}

	public void setTamanhoAro(Integer tamanhoAro) {
		this.tamanhoAro = tamanhoAro;
	}

}
