package model.service;

public class ServiceFactory {

	private static ServiceFactory instance;

	private ServiceFactory() {
		super();
	}

	public static ServiceFactory getInstance() {
		if (ServiceFactory.instance == null) {
			ServiceFactory.instance = new ServiceFactory();
		}
		return ServiceFactory.instance;
	}
	
	public AlunoService getAlunoService() {
		return new AlunoService();
	}
	
	public SalaService getSalaService() {
		SalaService service = new SalaService();
		return service;
	}
	
	public EnsalamentoService getEnsalamentoService() {
		EnsalamentoService service = new EnsalamentoService();
		return service;
	}

}
