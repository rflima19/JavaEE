package br.com.rafael.exercicio1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Eleitor {

	private String tituloEleitor;
	
	private String nome;
	
	private Set<Voto> votos;

	public Eleitor() {
		super();
		this.votos = new LinkedHashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}
	
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
}
