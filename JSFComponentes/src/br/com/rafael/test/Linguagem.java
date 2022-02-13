package br.com.rafael.test;

public class Linguagem {

	public static final Linguagem[] LINGUAGENS = new Linguagem[5];
	
	static {
		Linguagem.LINGUAGENS[0] = new Linguagem(1, "Java");
		Linguagem.LINGUAGENS[1] = new Linguagem(2, "OIS");
		Linguagem.LINGUAGENS[2] = new Linguagem(3, "C++");
		Linguagem.LINGUAGENS[3] = new Linguagem(4, "C#");
		Linguagem.LINGUAGENS[4] = new Linguagem(5, "PHP");
	}
	
	private String nome;
	private Integer id;
	
	public Linguagem(Integer id, String nome) {
		super();
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
