package br.com.rafael.test;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext fcx, UIComponent comp, Object value) throws ValidatorException {
		Date dateNasc = (Date) value;
		Date now = new Date();
		
		if ((dateNasc != null) && (dateNasc.compareTo(now) > 0)) {
			FacesMessage message = new FacesMessage("Ocorreu um erro: ", "A data de nascimento não pode ser maior que a data atual.");
			throw new ValidatorException(message);
		}
	}
}
