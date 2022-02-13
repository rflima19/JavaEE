package br.com.rafael.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.model.Produto;

@Stateless
public class ProdutoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Produto> listar() {
		return this.em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}
