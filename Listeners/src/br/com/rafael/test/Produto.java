package br.com.rafael.test;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Produto implements HttpSessionBindingListener {

	private String nome;
	private double preco;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		this.nome = null;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		this.nome = event.getName();
	}
}
