package br.com.rafael.test;

public class Endereco {

	private String rua;
	private String numero;

	public Endereco() {
		super();
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Rua: " + this.rua + " / N�mero: " + this.numero;
	}
}
