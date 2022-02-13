package br.com.rafael.test.javabeans;

/**
 * Classe JavaBean
 * */
public class Conta {

	private Integer numero;
	private Double saldo;
	
	public Conta() {
		super();
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
