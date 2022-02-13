package br.com.rafael.exercicio1;

public class Cargo {

	public enum NomeCargo {
		SENADOR, PRESIDENTE, PREFEITO;
	}
	
	private Integer id;
	
	private String nome;

	public Cargo() {
		super();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toString();
	}

	public Integer getId() {
		return this.id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
}
