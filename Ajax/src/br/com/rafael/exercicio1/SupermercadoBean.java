package br.com.rafael.exercicio1;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("compras")
@SessionScoped
public class SupermercadoBean implements Serializable {

	@Inject
	private Produto produto;
	
	private Set<Produto> produtos = new HashSet<>();

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String adicionar() {
		this.produto.setComprado(false);
		this.produtos.add(this.produto);
		this.produto = new Produto();
		return null;
	}
	
	public String excluir(Produto p) {
		this.produtos.remove(p);
		return null;
	}
	
	private void exibir() {
		Iterator<Produto> i = this.produtos.iterator();
		while (i.hasNext()) {
			Produto produto = (Produto) i.next();
			System.out.println(produto.getNome() + " - " + produto.getQuantidade() + " - " + produto.getComprado());
		}
	}
}
