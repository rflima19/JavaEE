package cadastro.servicos;

import java.util.List;

import cadastro.dao.DAOFactory;
import cadastro.dao.IntereseDAO;
import cadastro.entidades.Interese;

public class IntereseServico extends Servico {

	private DAOFactory daoFactory = DAOFactory.getInstance();
	private IntereseDAO intereseDao = this.daoFactory.getInterese();
	
	@Override
	public List<Interese> carregar() {
		return this.intereseDao.carregar();
	}
	
}
