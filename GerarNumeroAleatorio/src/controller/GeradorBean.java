package controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import model.Sorteio;

@Named("gerador")
@RequestScoped
public class GeradorBean implements Serializable {

	private Sorteio sorteio;

	public GeradorBean() {
		super();
		this.sorteio = new Sorteio();
	}
	
	public Sorteio getSorteio() {
		return sorteio;
	}

	public void setSorteio(Sorteio sorteio) {
		this.sorteio = sorteio;
	}

	public String gerar() {
		this.sorteio.sortear();
		return null;
	}

}
