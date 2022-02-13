package cadastro.dao;

public class DAOFactory {

	private static DAOFactory instance;
	
	private DAOFactory() {
		super();
	}

	public static DAOFactory getInstance() {
		if (DAOFactory.instance == null) {
			DAOFactory.instance = new DAOFactory();
		}
		return DAOFactory.instance;
	}
	
	public EstadoDAO getEstadoDAO() {
		return new EstadoDAO();
	}
	
	public IntereseDAO getInterese() {
		return new IntereseDAO();
	}
}
