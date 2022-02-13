package br.com.rafael.test;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("enderecoConverter2")
public class EnderecoConverter2 implements Converter {

	private String separador;

	@Override
	public Object getAsObject(FacesContext fcx, UIComponent comp, String value) {
		if (value == null) {
			return null;
		}
		try {
			String[] tokens = value.split(this.separador);
			Endereco e = new Endereco();
			e.setRua(tokens[0].trim());
			e.setNumero(tokens[1].trim());

			return e;
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Ocorreu um erro: ", "A conversão não pode ser feita.");
			throw new ConverterException(message);
		}
	}

	@Override
	public String getAsString(FacesContext fcx, UIComponent comp, Object value) {
		Endereco e = (Endereco) value;
		String result = e.getRua() + this.separador + e.getNumero();
		return result;
	}

	public String getSeparador() {
		return separador;
	}

	public void setSeparador(String separador) {
		this.separador = separador;
	}

}
