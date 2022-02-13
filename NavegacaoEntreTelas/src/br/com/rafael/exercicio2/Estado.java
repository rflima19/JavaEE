package br.com.rafael.exercicio2;

public class Estado {

	public static final Estado[] estados = new Estado[] {
		new Estado("AC", "Acre"),
		new Estado("MA", "Maranh�o"),
		new Estado("RJ", "Rio de Janeiro"),
		new Estado("AL", "Alagoas"),
		new Estado("MT", "Mato Grosso"),
		new Estado("RN", "Rio Grande do Norte"),
		new Estado("AP", "Amap�"),
		new Estado("MS", "Mato Grosso do Sul"),
		new Estado("RS", "Rio Grande do Sul"),
		new Estado("AM", "Amazonas"),
		new Estado("MG", "Minas Gerais"),
		new Estado("RO", "R�ndonia"),
		new Estado("BA", "Bahia"),
		new Estado("PA", "Par�"),
		new Estado("RR", "Roraima"),
		new Estado("CE", "Cear�"),
		new Estado("PB", "Para�ba"),
		new Estado("SC", "Santa Catarina"),
		new Estado("DF", "Distrito Federal"),
		new Estado("PR", "Paran�"),
		new Estado("SP", "S�o Paulo"),
		new Estado("ES", "Esp�rito Santo"),
		new Estado("PE", "Pernambuco"),
		new Estado("SE", "Sergipe"),
		new Estado("GO", "Goi�s"),
		new Estado("PI", "Piau�"),
		new Estado("TO", "Tocantins"),
	};
	
	private String nome;
	private String sigla;

	public Estado() {
		super();
	}

	public Estado(String sigla, String nome) {
		super();
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Estado[] getListaEstados() {
		return Estado.estados;
	}

}
