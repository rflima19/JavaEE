package br.com.rafael.test;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BemVindoTag extends SimpleTagSupport {

	private String usuario;
	
	@Override
	public void doTag() throws JspException, IOException {
		
		String str = null;
		LocalDateTime dateTime = LocalDateTime.now();
		int hora = dateTime.getHour();
		
		if ((hora >= 0) && (hora <= 11)) {
			str = "Bom dia";
		} else if ((hora >= 12) && (hora <= 17)) {
			str = "Boa tarde";
		} else {
			str = "Boa noite";
		}
		
		getJspContext().getOut().print(str + ", " + usuario);
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
