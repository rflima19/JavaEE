package br.com.rafael.test;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("index")
@RequestScoped
public class IndexBean implements Serializable {

	private static final long serialVersionUID = -5580564392704527515L;

	public String getMensagem() {
		return "Mensagem retornada do JavaBean";
	}
}
