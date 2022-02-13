package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("listarCompras")
@RequestScoped
public class ListaComprasBean implements Serializable {

	private List<ItemCompra> listaCompras;

	public ListaComprasBean() {
		super();
		this.listaCompras = new ArrayList<ItemCompra>();
		this.listaCompras.add(new ItemCompra("Feijão", 30, 5.30));
		this.listaCompras.add(new ItemCompra("Arroz", 20, 4.0));
		this.listaCompras.add(new ItemCompra("Macarrão", 23, 6.10));
		this.listaCompras.add(new ItemCompra("Ovo", 50, 1.50));
		this.listaCompras.add(new ItemCompra("Carne", 12, 9.70));
		this.listaCompras.add(new ItemCompra("Óleo", 12, 3.20));
		this.listaCompras.add(new ItemCompra("Sabonete", 21, 2.70));
		this.listaCompras.add(new ItemCompra("Leite", 45, 15.80));
	}

	public List<ItemCompra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<ItemCompra> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
	public Integer getSize() {
		return this.listaCompras.size();
	}
}
