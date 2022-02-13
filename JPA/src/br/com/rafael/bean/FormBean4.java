package br.com.rafael.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.ejb.QueryBean;

@Named("form4")
@RequestScoped
public class FormBean4 implements Serializable {

	@EJB
	private QueryBean queryBean;

	private String jpql;

	private String result;

	public String executar() {
		List<?> list = queryBean.executar(jpql);
		buildResult(list);
		return null;
	}

	private void buildResult(List<?> list) {
		StringBuilder str = new StringBuilder("");
		list.forEach(i -> {
			if (i instanceof Object[]) {
				str.append(Arrays.toString((Object[]) i) + "\n");
			} else {
				str.append(i + "\n");
			}
		});
		this.result = str.toString();
	}

	public String getJpql() {
		return jpql;
	}

	public void setJpql(String jpql) {
		this.jpql = jpql;
	}

	public String getResult() {
		return result;
	}
}
