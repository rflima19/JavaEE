package model.service;

import model.dao.DAOFactory;

public abstract class Service {

	protected ServiceFactory serviceFactory;
	
	protected DAOFactory daoFactory;
	
	protected Service() {
		super();
		this.serviceFactory = ServiceFactory.getInstance();
		this.daoFactory = DAOFactory.getInstance();
	}
}
