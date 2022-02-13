package br.com.rafael.test;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("form3")
@RequestScoped
public class FormBean3 implements Serializable {

	private Date dataNascimento;
	private Endereco endereco;

	public FormBean3() {
		super();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String processar() {
		System.out.println("Endereco: " + this.endereco);
		System.out.println("Rua: " + this.endereco.getRua());
		System.out.println("Número: " + this.endereco.getNumero());
		System.out.println("Data de Nascimento: " + this.dataNascimento);

		return "result";
	}
}
