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

@Named("form2")
@RequestScoped
public class FormBean2 implements Serializable {

	private String nome;
	private Integer idade;

	private Date dataNascimento;

	public FormBean2() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void validarInicial(FacesContext fcx, UIComponent comp, Object value) {
		String s = (String) value;

		if ((s == null) || (!(s.startsWith("a")) && !(s.startsWith("A")))) {
			FacesMessage message = new FacesMessage("Ocorreu um erro: ",
					"O valor do campo não inicia com o caractere 'a' ou 'A'.");
			throw new ValidatorException(message);
		}
	}
}
