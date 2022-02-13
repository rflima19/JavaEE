package model.dao;

import java.util.List;

import model.entity.Aluno;
import model.entity.Sala;

public class SalaDAO extends DAO<Sala> {

	public SalaDAO() {
		super(Sala.class);
	}

	public List<Sala> getSalas() throws DAOException {
		String hql = "FROM Sala AS s ORDER BY s.numero";
		return (List<Sala>) this.list(hql);
	}
	
	public Sala getSalaPorAluno(String matricula) throws DAOException {
		String hql = "SELECT a.sala FROM Aluno AS a WHERE a.matricula = " + matricula;
	
		return (Sala) this.list(hql).get(0);
	}
}
