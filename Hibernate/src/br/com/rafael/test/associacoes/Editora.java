package br.com.rafael.test.associacoes;

import java.util.LinkedHashSet;
import java.util.Set;

public class Editora {

	private Integer id;
	private String nome;
	
	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o One-to-Many
	 */
	private Set<Livro> livros;

	public Editora() {
		super();
		this.livros = new LinkedHashSet<Livro>();
	}

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
}
