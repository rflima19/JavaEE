package br.com.rafael.test;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator2")
public class DateValidator2 implements Validator {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void validate(FacesContext fcx, UIComponent comp, Object value) throws ValidatorException {
		Date dateNasc = (Date) value;
		Date now = new Date();

		if ((dateNasc != null) && (dateNasc.compareTo(now) > 0)) {
			FacesMessage message = new FacesMessage(this.mensagem);
			throw new ValidatorException(message);
		}
	}
}
