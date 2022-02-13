package br.com.rafael.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

@Named
@RequestScoped
public class ColorBean implements Serializable {

	private DualListModel<String> colors;

	public ColorBean() {
		super();
		List<String> source = new ArrayList<String>();
		List<String> target = new ArrayList<String>();

		source.add("Amarelo");
		source.add("Azul");
		source.add("Verde");
		source.add("Vermelho");
		source.add("Rosa");
		source.add("Branco");
		source.add("Preto");
		source.add("Cinza");

		this.colors = new DualListModel<String>(source, target);
	}

	public DualListModel<String> getColors() {
		return colors;
	}

	public void setColors(DualListModel<String> colors) {
		this.colors = colors;
	}

	public void onTransfer(TransferEvent event) {
		List<?> itensTransferidos = event.getItems();
		// event.isAdd(); // event.isRemove();
		String op = event.isAdd() ? "adicionados" : "removidos";
		
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada: ", "Itens " + op + ": " + itensTransferidos.toString());
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
	}
}
