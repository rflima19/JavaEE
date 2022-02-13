package br.com.rafael.exercicio2;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("inversor")
@RequestScoped
public class InversorDeTextoBean implements Serializable {

	private String texto;
	private String textoInvertido;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTextoInvertido() {
		return textoInvertido;
	}

	public void setTextoInvertido(String textoInvertido) {
		this.textoInvertido = textoInvertido;
	}

	public String inverter() {
		StringBuilder strb = new StringBuilder(this.texto);
		this.textoInvertido = strb.reverse().toString();
		return null;
	}
}
