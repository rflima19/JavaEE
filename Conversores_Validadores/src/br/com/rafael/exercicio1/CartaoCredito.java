package br.com.rafael.exercicio1;

import java.util.Date;

public class CartaoCredito {

	private String nome;
	private Bandeira bandeira;
	private String numero;
	private Date dataValidade;

	public CartaoCredito() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Bandeira[] getBandeiras() {
		return Bandeira.values();
	}
}
