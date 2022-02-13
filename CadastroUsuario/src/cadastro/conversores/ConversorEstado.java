package cadastro.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import cadastro.entidades.Estado;

@FacesConverter(forClass = Estado.class)
public class ConversorEstado implements Converter {

	@Override
	public Estado getAsObject(FacesContext fc, UIComponent comp, String value) throws ConverterException {
		String[] dadosEstado = value.split("-");
		if (dadosEstado.length != 2) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERRO DE LÓGICA:", "Padrão incorreto de String que representa um estado");
			throw new ConverterException(fm);
		}
		Estado estado = new Estado(dadosEstado[0].trim(), dadosEstado[1].trim());
		return estado;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent comp, Object value) {
		Estado estado = (Estado) value;
		String strEstado = estado.getSigla() + " - " + estado.getNome();
		return strEstado;
	}

}
