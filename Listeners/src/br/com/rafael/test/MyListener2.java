package br.com.rafael.test;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyListener2 implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String nomeAttr = event.getName();
		Object valorAttr = event.getValue();

		System.out.println("Atributo com nome " + nomeAttr + " e valor " + valorAttr + " adicionado no escopo Session");
	}

}
