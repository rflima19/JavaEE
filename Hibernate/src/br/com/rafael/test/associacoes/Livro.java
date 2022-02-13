package br.com.rafael.test.associacoes;

import java.util.LinkedHashSet;
import java.util.Set;

public class Livro {

	private String isbn;
	private String nome;
	private String autor;
	
	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o Many-to-One
	 * */
	private Editora editora;

	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o Many-to-Many
	 */
	private Set<Cliente> clientes;

	public Livro() {
		super();
		this.clientes = new LinkedHashSet<Cliente>();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
