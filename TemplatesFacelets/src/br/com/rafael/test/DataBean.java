package br.com.rafael.test;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DataBean implements Serializable {

	@Inject
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String exibirData() {
		if (this.data.validarData()) {
			System.out.println("DataBean [dia=" + data.getDia() + ", m�s=" + data.getMes() + ", ano=" + this.data.getAno() +"]");
		} else {
			System.out.println("Data: " + this.data.getDia() + "/" + this.data.getMes() + "/" + this.data.getAno() + " � inv�lida!");
		}
		return "exercicio2";
	}
}
