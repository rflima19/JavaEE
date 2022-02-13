package cadastro.dao;

import java.util.List;

public abstract class DAO {

	public abstract <T> List<T> carregar();
}
