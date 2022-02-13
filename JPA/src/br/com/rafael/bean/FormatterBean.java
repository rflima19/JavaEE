package br.com.rafael.bean;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FormatterBean implements Serializable {

	private static final Locale LOCALE = Locale.getDefault();
	
	public String formatarMoeda(Double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(FormatterBean.LOCALE);
		return nf.format(valor);
	}
}
