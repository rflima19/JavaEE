package jsf.javabean;

import java.io.Serializable;

public class Produto implements Serializable {

	private Integer id;
	private String nome;

	public Produto(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.id + " -> " + this.nome;
	}

}
