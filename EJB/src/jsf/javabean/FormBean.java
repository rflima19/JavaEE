package jsf.javabean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ejb.session.stateless.ConverteTemperaturaBeanLocal;

@Named("form")
@RequestScoped
public class FormBean implements Serializable {

	private Double tc;
	private Double tf;
	
	@EJB
	private ConverteTemperaturaBeanLocal conversor;

	public Double getTc() {
		return tc;
	}

	public void setTc(Double tc) {
		this.tc = tc;
	}

	public Double getTf() {
		return tf;
	}

	public void setTf(Double tf) {
		this.tf = tf;
	}

	public String convertCelsiusToFahrenheit() {
		this.tf = this.conversor.converterCelsiusParaFahrenheit(this.tc);
		return null;
	}
}
