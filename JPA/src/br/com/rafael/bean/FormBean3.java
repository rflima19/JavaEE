package br.com.rafael.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.ejb.VeiculoBean;
import br.com.rafael.ejb.VooBeanLocal;
import br.com.rafael.model.Voo;

@Named("form3")
@RequestScoped
public class FormBean3 implements Serializable {

	@EJB
	private VeiculoBean veiculoBean;

	public VeiculoBean getVeiculoBean() {
		return veiculoBean;
	}

	public String processar() {
		this.veiculoBean.processar();
		return null;
	}
}
