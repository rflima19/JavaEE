package model.entity;

import java.util.HashSet;
import java.util.Set;

public class Sala {

	private Integer numero;
	private Integer capacidade;
	private Turma turma;
	private Set<Aluno> alunos;

	public Sala() {
		super();
		this.alunos = new HashSet<>();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

}
