package br.com.rafael.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "aula_id", nullable = false)
	private Integer id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "duracao", nullable = false)
	private Integer duracao;

	@Column(name = "posicao", nullable = false)
	private Integer posicao;

	@ManyToOne
	private Modulo modulo;

	public Aula() {
		super();
	}

	public Aula(String nome, Integer duracao, Integer posicao, Modulo modulo) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.posicao = posicao;
		this.modulo = modulo;
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

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", nome=" + nome + ", duracao=" + duracao + ", posicao=" + posicao + ", modulo="
				+ modulo + "]";
	}

}
