package ejb.exercicio1;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named("conversao")
@RequestScoped
public class ConversaoBean implements Serializable {

	@EJB
	private EjbConversaoBeanLocal conversor;
	
	private String medida;
	private Double quilometro;
	private Double milha;

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public Double getQuilometro() {
		return quilometro;
	}

	public void setQuilometro(Double quilometro) {
		this.quilometro = quilometro;
	}

	public Double getMilha() {
		return milha;
	}

	public void setMilha(Double milha) {
		this.milha = milha;
	}

	public void update(AjaxBehaviorEvent event) {
		if (this.medida.equals("km")) {
			this.milha = null;
		} else if (this.medida.equals("mi")) {
			this.quilometro = null;
		}
	}
	
	public void update(ValueChangeEvent event) {
		String value = (String) event.getNewValue();
		if (value.equals("km")) {
			this.milha = null;
		} else if (value.equals("mi")) {
			this.quilometro = null;
		}
//		System.out.println(value);
//		FacesContext fc = FacesContext.getCurrentInstance();
//		fc.getRenderResponse();
	}
	
	public String converter() {
		if (this.medida.equals("km")) {
			this.milha = this.conversor.converterQuilometrosParaMilhas(this.quilometro);
		} else if (this.medida.equals("mi")) {
			this.quilometro = this.conversor.converterMilhasParaQuilometros(this.milha);
		}
		
		return "conversao";
	}
}
