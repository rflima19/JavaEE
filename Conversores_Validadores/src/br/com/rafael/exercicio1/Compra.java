package br.com.rafael.exercicio1;

import javax.inject.Inject;

public class Compra {

	@Inject
	private CartaoCredito cartaoCredito;
	private Double valor;

	public Compra() {
		super();
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
