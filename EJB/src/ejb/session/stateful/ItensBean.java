package ejb.session.stateful;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateful;

@Stateful
public class ItensBean implements ItensBeanLocal {

	private List<String> itens = new ArrayList<>();

	@Override
	public void adicionarItem(String item) {
		this.itens.add(item);
		this.imprimirItens();
	}

	@Override
	public void removerItem(String item) {
		this.itens.remove(item);
		this.imprimirItens();
	}
	
	public List<String> getItens() {
		return this.itens;
	}
	
	private void imprimirItens() {
		System.out.println("Itens cadastrados:");
		for (Iterator iterator = itens.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}
}
