package br.com.rafael.exercicio2;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class DataBean implements Serializable {

	private static final long serialVersionUID = -2452166251123323590L;
	
	@Inject
	private Data data;

	public DataBean() {
		super();
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public String showDate() {
		System.out.println(data.getDay() + "/" + data.getMonth() + "/" + data.getYear());
		return null;
	}

}
