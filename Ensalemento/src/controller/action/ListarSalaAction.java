package controller.action;

import java.util.List;

import model.entity.Sala;
import model.service.SalaService;

public class ListarSalaAction extends Action {

	@Override
	public void process() throws Exception {
		SalaService salaService = this.serviceFactory.getSalaService();
		List<Sala> list = salaService.getSalas();
		
		this.getRequest().setAttribute("salas", list);
		this.forward("lista_salas.jsp");
	}

}
