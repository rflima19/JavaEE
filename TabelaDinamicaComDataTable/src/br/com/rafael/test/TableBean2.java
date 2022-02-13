package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

@Named("table2")
@SessionScoped
public class TableBean2 implements Serializable {

	private static final long serialVersionUID = -7214769883625943741L;

	private List<Despesa> despesasList;
	private ListDataModel<Despesa> despesas;

	public TableBean2() {
		super();
		this.despesasList = new ArrayList<Despesa>();
		this.despesas = new ListDataModel<Despesa>(this.despesasList);
	}

	public String inserir() {
		Despesa despesa = new Despesa();
		despesa.setEdit(true);
		this.despesasList.add(despesa);
		return null;
	}

	public String excluir(Despesa despesa) {
		this.despesasList.remove(despesa);
		return null;
	}

	public String editar(Despesa despesa) {
		despesa.setEdit(true);
		return null;
	}

	public String atualizar(Despesa despesa) {
		despesa.setEdit(false);
		return null;
	}

	public List<Despesa> getDespesasList() {
		return despesasList;
	}

	public void setDespesasList(List<Despesa> despesasList) {
		this.despesasList = despesasList;
	}

	public ListDataModel<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(ListDataModel<Despesa> despesas) {
		this.despesas = despesas;
	}

}
