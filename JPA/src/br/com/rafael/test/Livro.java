package br.com.rafael.test;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id_livro", nullable = false)
	private Integer id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "autor", length = 30, nullable = false)
	private String autor;

	@Column(name = "numero_paginas", nullable = false)
	private Integer numeroPaginas;

	public Livro() {
		super();
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

}
