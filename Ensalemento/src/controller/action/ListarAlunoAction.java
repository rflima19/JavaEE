package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.dao.AlunoDAO;
import model.entity.Aluno;
import model.entity.Sala;
import model.service.SalaService;

public class ListarAlunoAction extends Action {

	@Override
	public void process() throws Exception {
		
		HttpServletRequest request = this.getRequest();
		Integer numSala = Integer.valueOf(request.getParameter("numSala"));
		String ordemStr = request.getParameter("ordem");
		AlunoDAO.Ordem ordem = (ordemStr == null) ? AlunoDAO.Ordem.MATRICULA : AlunoDAO.Ordem.valueOf(ordemStr);
		
		SalaService salaService = this.serviceFactory.getSalaService();
		List<Aluno> list = salaService.getAlunosPorSala(numSala, ordem);
		
		Sala sala = salaService.loadSala(numSala);
		
		request.setAttribute("alunos", list);
		request.setAttribute("qtdAlunos", list.size());
		request.setAttribute("sala", sala);
		this.forward("lista_alunos.jsp");
	}

}
