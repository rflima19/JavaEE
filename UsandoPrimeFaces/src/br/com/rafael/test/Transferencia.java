package br.com.rafael.test;

public class Transferencia {

	private String banco;
	private Integer valor;
	private Integer repet;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getRepet() {
		return repet;
	}

	public void setRepet(Integer repet) {
		this.repet = repet;
	}

	@Override
	public String toString() {
		return "Transferencia [banco=" + banco + ", valor=" + valor + ", repet=" + repet + "]";
	}

}
