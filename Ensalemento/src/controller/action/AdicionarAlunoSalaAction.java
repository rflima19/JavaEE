package controller.action;

import javax.servlet.http.HttpServletRequest;

import model.service.EnsalamentoService;

public class AdicionarAlunoSalaAction extends Action {

	@Override
	public void process() throws Exception {
	
		HttpServletRequest request = this.getRequest();
		
		String matricula = request.getParameter("matricula");
		Integer numSala = Integer.valueOf(request.getParameter("numSala"));
		
		EnsalamentoService ensalamentoService = this.serviceFactory.getEnsalamentoService();
		ensalamentoService.adicionarAlunoSala(matricula, numSala);
		
		this.redirect("ListarAlunos.action?numSala=" + numSala);
	}

}
