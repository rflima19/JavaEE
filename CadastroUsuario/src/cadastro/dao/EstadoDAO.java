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
		estados.add(new Estado("AP", "Amapá"));
		estados.add(new Estado("AM", "Amazonas"));
		estados.add(new Estado("BA", "Bahia"));
		estados.add(new Estado("CE", "Ceará"));
		estados.add(new Estado("DF", "Distrito Federal"));
		estados.add(new Estado("ES", "Espírito Santo"));
		estados.add(new Estado("GO", "Goiás"));
		estados.add(new Estado("MA", "Maranhão"));
		estados.add(new Estado("MT", "Mato Grosso"));
		estados.add(new Estado("MS", "Mato Grosso do Sul"));
		estados.add(new Estado("MG", "Minas Gerais"));
		estados.add(new Estado("PA", "Pará"));
		estados.add(new Estado("PB", "Paraíba"));
		estados.add(new Estado("PR", "Paraná"));
		estados.add(new Estado("PE", "Pernambuco"));
		estados.add(new Estado("PI", "Piauí"));
		estados.add(new Estado("RJ", "Rio de Janeiro"));
		estados.add(new Estado("RN", "Rio Grande do Norte"));
		estados.add(new Estado("RS", "Rio Grande do Sul"));
		estados.add(new Estado("RO", "Rondônia"));
		estados.add(new Estado("RR", "Roraima"));
		estados.add(new Estado("SC", "Santa Catarina"));
		estados.add(new Estado("SP", "São Paulo"));
		estados.add(new Estado("SE", "Sergipe"));
		estados.add(new Estado("TO", "Tocantins"));

		return estados;
	}
}
