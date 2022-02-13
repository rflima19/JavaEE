package model.service;

import java.util.List;

import model.dao.AlunoDAO;
import model.dao.DAOException;
import model.entity.Aluno;

public class AlunoService extends Service {

	public List<Aluno> getAlunoPorNome(String nome) throws ServiceException {
		try {
			AlunoDAO alunoDAO = this.daoFactory.getAlunoDAO();
			List<Aluno> list = alunoDAO.getAlunosNaoEnsaladosPorNome(nome);
			return list;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
