package br.com.rafael.exercicio1;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("gerador")
@RequestScoped
public class GeradorNumericoBean implements Serializable {

	private Integer intervaloMaximo;
	private Integer intervaloMinino;
	private Integer quantidadeNumeros;
	private Integer[] valoresGerados;
	private Boolean exibirResultado;
	
	public GeradorNumericoBean() {
	}

	public Integer getIntervaloMaximo() {
		return intervaloMaximo;
	}

	public void setIntervaloMaximo(Integer intervaloMaximo) {
		this.intervaloMaximo = intervaloMaximo;
	}

	public Integer getIntervaloMinino() {
		return intervaloMinino;
	}

	public void setIntervaloMinino(Integer intervaloMinino) {
		this.intervaloMinino = intervaloMinino;
	}

	public Integer getQuantidadeNumeros() {
		return quantidadeNumeros;
	}

	public void setQuantidadeNumeros(Integer quantidadeNumeros) {
		this.quantidadeNumeros = quantidadeNumeros;
	}

	public Integer[] getValoresGerados() {
		return valoresGerados;
	}

	public void setValoresGerados(Integer[] valoresGerados) {
		this.valoresGerados = valoresGerados;
	}
	
	public Boolean getExibirResultado() {
		return exibirResultado;
	}

	public void setExibirResultado(Boolean exibirResultado) {
		this.exibirResultado = exibirResultado;
	}

	public String gerarNumeroAleatorio() {
		this.valoresGerados = new Integer[this.quantidadeNumeros];
		int inicio = this.intervaloMinino;
		int fim = this.intervaloMaximo + 1;
		int intervalo = fim - inicio;
		int n = 0;
		for (int i = 0; i < this.quantidadeNumeros; i++) {
			n = (int) (Math.random() * intervalo) + inicio;
			this.valoresGerados[i] = n;
		}
		this.exibirResultado = true;
		return null;
	}
	
	public Integer[] getListarValoresGerados() {
		return this.valoresGerados;
	}
}
