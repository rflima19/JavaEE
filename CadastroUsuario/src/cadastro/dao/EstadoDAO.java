package cadastro.dao;

import java.util.ArrayList;
import java.util.List;

import cadastro.entidades.Estado;

public class EstadoDAO extends DAO {

	@Override
	public List<Estado> carregar() {
		List<Estado> estados = new ArrayList<>();
		estados.add(new Estado("AC", "Acre"));
		estados.add(new Estado("AL", "Alagoas"));
		estados.add(new Estado("AP", "Amap�"));
		estados.add(new Estado("AM", "Amazonas"));
		estados.add(new Estado("BA", "Bahia"));
		estados.add(new Estado("CE", "Cear�"));
		estados.add(new Estado("DF", "Distrito Federal"));
		estados.add(new Estado("ES", "Esp�rito Santo"));
		estados.add(new Estado("GO", "Goi�s"));
		estados.add(new Estado("MA", "Maranh�o"));
		estados.add(new Estado("MT", "Mato Grosso"));
		estados.add(new Estado("MS", "Mato Grosso do Sul"));
		estados.add(new Estado("MG", "Minas Gerais"));
		estados.add(new Estado("PA", "Par�"));
		estados.add(new Estado("PB", "Para�ba"));
		estados.add(new Estado("PR", "Paran�"));
		estados.add(new Estado("PE", "Pernambuco"));
		estados.add(new Estado("PI", "Piau�"));
		estados.add(new Estado("RJ", "Rio de Janeiro"));
		estados.add(new Estado("RN", "Rio Grande do Norte"));
		estados.add(new Estado("RS", "Rio Grande do Sul"));
		estados.add(new Estado("RO", "Rond�nia"));
		estados.add(new Estado("RR", "Roraima"));
		estados.add(new Estado("SC", "Santa Catarina"));
		estados.add(new Estado("SP", "S�o Paulo"));
		estados.add(new Estado("SE", "Sergipe"));
		estados.add(new Estado("TO", "Tocantins"));

		return estados;
	}
}
