package br.com.rafael.exercicio1;

public class Candidato {

	private Integer id;

	private String nome;

	private Cargo cargo;

	public Candidato() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
}
