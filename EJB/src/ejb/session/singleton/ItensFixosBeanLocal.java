package ejb.session.singleton;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ItensFixosBeanLocal {

	public List<String> getItens();
}
