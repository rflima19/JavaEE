package controller.action;

import javax.servlet.http.HttpServletRequest;

import model.entity.Sala;
import model.service.EnsalamentoService;

public class ExcluirAlunoSalaAction extends Action {

	@Override
	public void process() throws Exception {
		
		HttpServletRequest request = this.getRequest();
		
		String matricula = request.getParameter("matricula");
		
		EnsalamentoService ensalamentoService = this.serviceFactory.getEnsalamentoService();
		
		Sala sala = ensalamentoService.getSalaPorAluno(matricula);
		
		ensalamentoService.removerAlunoSala(matricula);
		
		this.redirect("ListarAlunos.action?numSala=" + sala.getNumero());
	}

}
