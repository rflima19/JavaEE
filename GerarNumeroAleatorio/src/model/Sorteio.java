package model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class Sorteio {

	private Integer minimo;
	private Integer maximo;
	private Integer quantidade;
	private List<Integer> resultado = new ArrayList<>();

	public Integer getMinimo() {
		return minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

	public Integer getMaximo() {
		return maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Integer> getResultado() {
		return resultado;
	}

	public void sortear() {
		for (int i = 0; i < this.quantidade; i++) {
			this.resultado.add(this.gerarNumero());
		}
	}

	public int gerarNumero() {
		int aux = this.maximo + 1;
		int intervalo = aux - this.minimo;
		int n = (int) (Math.random() * intervalo) + this.minimo;
		return n;
	}
	
	public void validarIntervalo(FacesContext fc, UIComponent comp, Object value) throws ValidatorException {
		UIInput inputMinimo = (UIInput) comp.findComponent("vlMinimo");
		UIInput inputMaximo = (UIInput) comp.findComponent("vlMaximo");
		
		Integer minimo = (Integer) inputMinimo.getLocalValue();
		Integer maximo = (Integer) inputMaximo.getLocalValue();
		
		if (minimo.compareTo(maximo) > 0) {
			// throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Valor mínimo não pode ser maior que valor máximo"));
			
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: ", "Valor mínimo não pode ser maior que valor máximo");
			fc.addMessage("form:vlMinimo", fm);
	
			fc.renderResponse();
		}
	}
}
