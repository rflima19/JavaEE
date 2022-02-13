package br.com.rafael.test.associacoes;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cliente {

	private Integer id;
	private String nome;
	
	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o One-to-One
	 * */
	private RG rg;

	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o Many-to-Many
	 */
	private Set<Livro> livros;

	public Cliente() {
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

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}
}
