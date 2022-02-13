package br.com.rafael.exemplo2.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Produto {

	private static Map<Integer, Produto> listaProdutos;
	
	static {
		Produto.listaProdutos = new LinkedHashMap<>();
		
		Produto.listaProdutos.put(1, new Produto(1, "P1", 198.12));
		Produto.listaProdutos.put(2, new Produto(2, "P2", 258.62));
		Produto.listaProdutos.put(3, new Produto(3, "P3", 143.12));
		Produto.listaProdutos.put(4, new Produto(4, "P4", 198.00));
		Produto.listaProdutos.put(5, new Produto(5, "P5", 8.15));
		Produto.listaProdutos.put(6, new Produto(6, "P6", 9.12));
	}
	
	private int id;
	private String nome;
	private double valor;
	
	public Produto(int id, String nome, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public double getValor() {
		return this.valor;
	}
	
	public static Collection<Produto> getProdutos() {
		return Produto.listaProdutos.values();
	}
	
	public static Produto getProdutoById(int id) {
		return Produto.listaProdutos.get(id);
	}
}
