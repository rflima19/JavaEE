package br.com.rafael.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 135813716260533764L;

	private String name;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String doLogin() {
		if("abc".equals(name) && "123".equals(password)) {
			return "success";
		}
		
		FacesContext.getCurrentInstance().addMessage("form:button", new FacesMessage("Login Inválido!"));
		
		return null;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Bean criado!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Bean destruído!");
	}
}
