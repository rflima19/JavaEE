package model.dao;

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
	
	public AlunoDAO getAlunoDAO() {
		AlunoDAO dao = new AlunoDAO();
		return dao;
	}
	
	public SalaDAO getSalaDAO() {
		return new SalaDAO();
	}
}
