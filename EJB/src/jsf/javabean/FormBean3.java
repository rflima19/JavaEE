package jsf.javabean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ejb.session.singleton.ItensFixosBeanLocal;

@Named("form3")
@RequestScoped
public class FormBean3 implements Serializable {

	@EJB
	private ItensFixosBeanLocal itensFixosBean;
	
	public List<String> getItens() {
		return this.itensFixosBean.getItens();
	}

}
