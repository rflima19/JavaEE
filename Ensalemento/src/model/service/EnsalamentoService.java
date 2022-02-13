package model.service;

import model.dao.AlunoDAO;
import model.dao.DAOException;
import model.dao.SalaDAO;
import model.entity.Aluno;
import model.entity.Sala;

public class EnsalamentoService extends Service {

	public void removerAlunoSala(String matricula) throws ServiceException {
		try {
			AlunoDAO alunoDAO = this.daoFactory.getAlunoDAO();
			Aluno aluno = alunoDAO.load(matricula);
			aluno.setSala(null);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void adicionarAlunoSala(String matricula, int numSala) throws ServiceException {
		try {
			AlunoDAO alunoDAO = this.daoFactory.getAlunoDAO();
			Aluno aluno = alunoDAO.load(matricula);
			aluno.setSala(null);
			
			SalaDAO salaDAO = this.daoFactory.getSalaDAO();
			Sala sala = salaDAO.load(Integer.valueOf(numSala));
			
			aluno.setSala(sala);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public Sala getSalaPorAluno(String matricula) throws ServiceException {
		try {
			SalaDAO salaDAO = this.daoFactory.getSalaDAO();
			Sala sala = salaDAO.getSalaPorAluno(matricula);
			return sala;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
