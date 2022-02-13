package ejb.session.stateful;

import java.util.List;

public interface ItensBeanLocal {

	public void adicionarItem(String item);
	
	public void removerItem(String item);
	
	public List<String> getItens();
}
