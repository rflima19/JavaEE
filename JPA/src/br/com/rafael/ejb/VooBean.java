package br.com.rafael.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.rafael.model.Voo;
import br.com.rafael.model.VooPK;

@Stateless
public class VooBean implements VooBeanLocal {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION, unitName = "APPTestJPA")
	private EntityManager entityManager;

	public void inserir(Voo voo) {
		this.entityManager.persist(voo);
	}

	public Voo carregar(Integer numero, String empresa) {
		Voo voo = this.entityManager.find(Voo.class, new VooPK(numero, empresa));
		return voo;
	}

}
