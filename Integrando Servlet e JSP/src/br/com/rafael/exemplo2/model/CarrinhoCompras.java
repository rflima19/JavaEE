package br.com.rafael.exemplo2.model;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private List<Produto> produtos;

	public CarrinhoCompras() {
		super();
		this.produtos = new ArrayList<>();
	}
	
	public void add(Produto p) {
		this.produtos.add(p);
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
}
