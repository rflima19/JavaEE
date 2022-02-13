package model.service;

import java.util.List;

import model.dao.AlunoDAO;
import model.dao.DAOException;
import model.dao.SalaDAO;
import model.entity.Aluno;
import model.entity.Sala;

public class SalaService extends Service {

	public List<Sala> getSalas() throws ServiceException {
		try {
			SalaDAO salaDAO = this.daoFactory.getSalaDAO();
			List<Sala> list = salaDAO.getSalas();
			return list;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<Aluno> getAlunosPorSala(int numSala, AlunoDAO.Ordem ordem) throws ServiceException {
		try {
			AlunoDAO alunoDAO = this.daoFactory.getAlunoDAO();
			List<Aluno> list = alunoDAO.getAlunosPorSala(numSala, ordem);
			return list;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public Sala loadSala(int numSala) throws ServiceException {
		try {
			SalaDAO salaDAO = this.daoFactory.getSalaDAO();
			Sala list = salaDAO.load(numSala);
			return list;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
