package br.com.rafael.exercicio4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalDateTime.class)
public class LocaDateTimeConverte implements Converter<LocalDateTime> {

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	@Override
	public LocalDateTime getAsObject(FacesContext fc, UIComponent comp, String str) {
		if (str == null) {
			return null;
		}
		return LocalDateTime.parse(str, this.dtf);
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent comp, LocalDateTime ldt) {
		if (ldt == null) {
			return null;
		}
		return ldt.format(this.dtf);
	}
}
