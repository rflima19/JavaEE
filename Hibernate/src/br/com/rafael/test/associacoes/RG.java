package br.com.rafael.test.associacoes;

import java.time.LocalDate;
import java.util.Date;

public class RG {

	private Integer id;
	
	/**
	 * O relacionamento no c�digo fonte das entidades � feito atrav�s de atributos
	 * que referenciam as outras entidades.
	 * 
	 * Associa��o One-to-One
	 * */
	private Cliente cliente;
	
	private String numero;
	private LocalDate dataExpedicao;

	public RG() {
		super();
	}

	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataExpedicao() {
		return this.dataExpedicao;
	}

	public void setDataExpedicao(LocalDate dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}	
}
