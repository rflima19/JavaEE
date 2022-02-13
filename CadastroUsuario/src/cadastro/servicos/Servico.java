package cadastro.servicos;

import java.util.List;

public abstract class Servico {

	public abstract <T> List<T> carregar();
}
