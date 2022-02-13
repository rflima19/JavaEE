package br.com.rafael.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.ejb.QueryBean2;

@Named("form5")
@RequestScoped
public class FormBean5 implements Serializable {

	@EJB
	private QueryBean2 queryBean;

	private Integer opcao;

	private String result;

	public String executar() {

		List<?> list = null;

		switch (opcao) {
		case 1:
			list = queryBean.executar1();
			break;
		case 2:
			list = queryBean.executar2();
			break;
		case 3:
			list = queryBean.executar3();
			break;
		case 4:
			list = queryBean.executar4();
			break;
		}

		buildResult(list);
		return null;
	}

	private void buildResult(List<?> list) {
		result = "";
		list.forEach(i -> {
			if (i instanceof Object[]) {
				result += Arrays.toString((Object[]) i) + "\n";
			} else {
				result += i + "\n";
			}
		});
	}

	public String getResult() {
		return result;
	}

	public Integer getOpcao() {
		return opcao;
	}

	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}
}
