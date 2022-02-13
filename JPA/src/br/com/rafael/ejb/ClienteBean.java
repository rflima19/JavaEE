package br.com.rafael.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Cliente2;

@Stateless
public class ClienteBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente2> listar() {
		return this.em.createQuery("SELECT c FROM Cliente2 c", Cliente2.class).getResultList();
	}
}
