package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

@Named("table")
@RequestScoped
public class TableBean implements Serializable {

	private static List<Despesa> despesas;

	private Despesa selectedDespesa;
	
	private Despesa[] selectedDespesas;

	static {
		despesas = new ArrayList<Despesa>();
		despesas.add(new Despesa(1, "02/10/2014", "Restaurante Comida Boa", "Alimentaçăo", 95.0));
		despesas.add(new Despesa(2, "03/10/2014", "Salăo de Beleza", "Beleza e Estética", 87.0));
		despesas.add(new Despesa(3, "04/10/2014", "Energia Elétrica", "Casa", 115.0));
		despesas.add(new Despesa(4, "04/10/2014", "Combustível", "Automóvel", 130.5));
		despesas.add(new Despesa(5, "05/10/2014", "Doce", "Alimentaçăo", 3.0));
		despesas.add(new Despesa(6, "06/10/2014", "Livro", "Livros e Revistas", 39.9));
		despesas.add(new Despesa(7, "06/10/2014", "Uniforme escolar", "Vestuário", 150.4));
		despesas.add(new Despesa(8, "04/10/2014", "Sapato", "Vestuário", 110.9));
	}

	public TableBean() {
		super();
	}

	public List<Despesa> getDespesas() {
		return TableBean.despesas;
	}

	public Despesa getSelectedDespesa() {
		return selectedDespesa;
	}

	public void setSelectedDespesa(Despesa selectedDespesa) {
		this.selectedDespesa = selectedDespesa;
	}
	
	public Despesa[] getSelectedDespesas() {
		return selectedDespesas;
	}

	public void setSelectedDespesas(Despesa[] selectedDespesas) {
		this.selectedDespesas = selectedDespesas;
	}

	public String processar() {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa selecionada:", this.selectedDespesa.getDescricao());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		return null;
	}
	
	public String processar2() {
		StringBuilder strb = new StringBuilder();
		for (Despesa despesa : selectedDespesas) {
			strb.append(" - " + despesa.getDescricao() + " - ");
		}
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesas selecionadas:\n", strb.toString());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
		return null;
	}

	public void onEdit(RowEditEvent event) {
		Despesa desp = (Despesa) event.getObject();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Despesa editada:", desp.getDescricao());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
	}
	
	public void onCancel(RowEditEvent event) {
		Despesa desp = (Despesa) event.getObject();
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelada a edição da despesa:", desp.getDescricao());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
	}
}
