package cadastro.servicos;

import java.util.List;

import cadastro.dao.DAOFactory;
import cadastro.dao.EstadoDAO;
import cadastro.entidades.Estado;

public class EstadoServico extends Servico {

	private DAOFactory daoFactory = DAOFactory.getInstance();
	private EstadoDAO estadoDao = this.daoFactory.getEstadoDAO();
	
	@Override
	public List<Estado> carregar() {
		return estadoDao.carregar();
	}
}
