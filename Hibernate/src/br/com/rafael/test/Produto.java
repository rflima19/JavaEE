package br.com.rafael.test;

/**
 * Entidade
 * 
 * Classe POJO para mapeamento objeto-relacional no Hibernate.
 */
public class Produto {

	/**
	 * Toda classe que é uma entidade no Hibernate deve possuir um ID que a
	 * identifique unicamente.
	 */
	private Integer id;
	
	private String nome;
	
	private Double valor;

	public Produto() {
	}

	public Integer getId() {
		return this.id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
