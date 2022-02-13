package br.com.rafael.test;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private Integer numeroInteriro;
	private Double numeroDecimal;
	private Character caractere;
	private Date data;
	private Opcao opcao;
	
	private Endereco endereco;

	public String processar() {
		System.out.println("Número inteiro: " + this.numeroInteriro);
		System.out.println("Número decimal: " + this.numeroDecimal);
		System.out.println("Caractere: " + this.caractere);
		System.out.println("Data: " + this.data);
		System.out.println("Opção: " + this.opcao);
		System.out.println("Endereco: " + this.endereco);
		System.out.println("Rua: " + this.endereco.getRua());
		System.out.println("Número: " + this.endereco.getNumero());

		return "result";
	}

	public Integer getNumeroInteriro() {
		return numeroInteriro;
	}

	public void setNumeroInteriro(Integer numeroInteriro) {
		this.numeroInteriro = numeroInteriro;
	}

	public Double getNumeroDecimal() {
		return numeroDecimal;
	}

	public void setNumeroDecimal(Double numeroDecimal) {
		this.numeroDecimal = numeroDecimal;
	}

	public Character getCaractere() {
		return caractere;
	}

	public void setCaractere(Character caractere) {
		this.caractere = caractere;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Opcao getOpcao() {
		return opcao;
	}

	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
