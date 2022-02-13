package model.dao;

import java.util.List;

import model.entity.Aluno;

public class AlunoDAO extends DAO<Aluno> {

	public enum Ordem {
		MATRICULA, NOME;
	}

	public AlunoDAO() {
		super(Aluno.class);
	}

	public List<Aluno> getAlunosNaoEnsaladosPorNome(String nome) throws DAOException {
		nome = nome.toUpperCase();
		String hql = "FROM Aluno AS a WHERE UPPER(a.nome) LIKE '%" + nome + "%' AND a.sala IS NULL";
		return (List<Aluno>) this.list(hql);
	}
	
	public List<Aluno> getAlunosPorSala(int numSala, AlunoDAO.Ordem ordem) throws DAOException {
		String hql = "FROM Aluno AS a WHERE a.sala.numero = " + numSala;
		
		if (ordem.equals(AlunoDAO.Ordem.MATRICULA)) {
			hql += " ORDER BY a.matricula";
		} else if (ordem.equals(AlunoDAO.Ordem.NOME)) {
			hql += " ORDER BY a.nome";
		}
		
		return (List<Aluno>) this.list(hql);
	}
}
