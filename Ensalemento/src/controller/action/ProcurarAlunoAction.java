package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.entity.Aluno;
import model.service.AlunoService;

public class ProcurarAlunoAction extends Action {

	@Override
	public void process() throws Exception {
		
		HttpServletRequest request = this.getRequest();
		
		String nome = request.getParameter("nome");
		Integer numSala = Integer.valueOf(request.getParameter("numSala"));
		
		request.setAttribute("numSala", numSala);
		
		if (!(nome == null)) {
			AlunoService alunoService = this.serviceFactory.getAlunoService();
			List<Aluno> list = alunoService.getAlunoPorNome(nome);
			request.setAttribute("alunos", list);
		}
		
		this.forward("procurar_alunos.jsp");
	}

}
