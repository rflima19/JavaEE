package br.com.rafael.exercicio1;

public class Voto {

	private Integer id;
	
	private Candidato candidato;
	
	private Eleitor eleitor;

	public Voto() {
		super();
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Integer getId() {
		return id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}
}
