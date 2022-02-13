package cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import cadastro.entidades.Interese;

public class IntereseDAO extends DAO {

	@Override
	public List<Interese> carregar() {
		List<Interese> intereses = new ArrayList<>();
		intereses.add(new Interese(1, "Esportes"));
		intereses.add(new Interese(2, "Músicas"));
		intereses.add(new Interese(3, "Arte Marciais"));
		intereses.add(new Interese(4, "Viagens"));
		intereses.add(new Interese(5, "Cinema"));
		intereses.add(new Interese(6, "Dança"));
		return null;
	}
}
