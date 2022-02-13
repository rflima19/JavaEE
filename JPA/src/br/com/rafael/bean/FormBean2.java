package br.com.rafael.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafael.ejb.VooBeanLocal;
import br.com.rafael.model.Voo;

@Named("form2")
@RequestScoped
public class FormBean2 implements Serializable {

	@EJB
	private VooBeanLocal vooBean;
	
	public String processar() {
		
		int numero = 1266;
		String empresa = "LATAN";
		
		Voo voo = new Voo();
		voo.setNumero(numero);
		voo.setEmpresa(empresa);
		voo.setOrigem("São Paulo");
		voo.setDestino("Paris");
		
		this.vooBean.inserir(voo);
		
		Voo voo2 = this.vooBean.carregar(numero, empresa);
		System.out.println(voo2);
		
		return null;
	}
}
