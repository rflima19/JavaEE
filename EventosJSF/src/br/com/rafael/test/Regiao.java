package br.com.rafael.test;

import java.util.Set;
import java.util.TreeSet;

public class Regiao implements Comparable<Regiao> {

	private String sigla;
	private String nome;
	private Set<Estado> estados;

	public Regiao(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
		this.estados = new TreeSet<Estado>();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Set<Estado> estados) {
		this.estados = estados;
	}

	@Override
	public int compareTo(Regiao regiao) {
		return this.nome.compareTo(regiao.nome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regiao other = (Regiao) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

}
