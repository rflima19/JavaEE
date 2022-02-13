package br.com.rafael.test;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class RegioesProvider {

	private static final Map<String, Regiao> REGIOES_MAP = new TreeMap<String, Regiao>();
	
	static {
		Regiao regiao = null;
		Estado estado = null;
		
		regiao = new Regiao("Sul", "S");
		RegioesProvider.REGIOES_MAP.put("S", regiao);
		estado = new Estado("RS", "Rio Grande do Sul", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("SC", "Santa Catarina", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PR", "Paran�", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Sudeste", "SE");
		RegioesProvider.REGIOES_MAP.put("SE", regiao);
		estado = new Estado("SP", "S�o Paulo", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RJ", "Rio de Janeiro", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("ES", "Esp�rito Santo", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MG", "Minas Gerais", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Nordeste", "NE");
		RegioesProvider.REGIOES_MAP.put("NE", regiao);
		estado = new Estado("BA", "Bahia", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("SE", "Sergipe", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AL", "Alagoas", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PE", "Pernambuco", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PB", "Para�ba", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RN", "Rio Grande do Norte", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("CE", "Cear�", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PI", "Piau�", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MA", "Maranh�o", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Norte", "N");
		RegioesProvider.REGIOES_MAP.put("N", regiao);
		estado = new Estado("AM", "Amazonas", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("PA", "Par�", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AC", "Acre", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RO", "Rond�nia", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("RR", "Roraima", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("TO", "Tocantins", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("AP", "Amap�", regiao);
		regiao.getEstados().add(estado);
		
		regiao = new Regiao("Centro-Oeste", "CO");
		RegioesProvider.REGIOES_MAP.put("CO", regiao);
		estado = new Estado("MS", "Mato Grosso do Sul", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("MT", "Mato Grosso", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("GO", "Goi�s", regiao);
		regiao.getEstados().add(estado);
		estado = new Estado("DF", "Distrito Federal", regiao);
		regiao.getEstados().add(estado);
	}
	
	public static Collection<Regiao> getRegioes() {
		return RegioesProvider.REGIOES_MAP.values();
	}
	
	public static Collection<Estado> getEstadosByRegiao(String siglaRegiao) {
		Regiao regiao = RegioesProvider.REGIOES_MAP.get(siglaRegiao);
		if (regiao == null) {
			return Collections.emptyList();
		}
		return regiao.getEstados();
	}
}
