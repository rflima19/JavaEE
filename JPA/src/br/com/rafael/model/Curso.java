package br.com.rafael.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "curso_id", nullable = false)
	private Integer id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@OneToMany(mappedBy = "curso")
	private List<Modulo> modulos;

	public Curso() {
		super();
	}
	
	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", modulos=" + modulos + "]";
	}

}
