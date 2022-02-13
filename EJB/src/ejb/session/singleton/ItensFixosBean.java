package ejb.session.singleton;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class ItensBean
 */
@Singleton
@Startup
public class ItensFixosBean implements ItensFixosBeanLocal {

	private List<String> itens = new ArrayList<>();
	
    public ItensFixosBean() {
    }
    
    @PostConstruct
    public void setup() {
    	this.itens.add("Arroz");
    	this.itens.add("Feijão");
    	this.itens.add("Macarrão");
    	this.itens.add("Lasanha");
    	System.out.println("Itens inicializados");
    }

	@Override
	public List<String> getItens() {
		return this.itens;
	}
    
    

}
