package br.com.rafael.test.javaee.ejb;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.rafael.test.model.Item;

@Stateful
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ItensBean implements Serializable {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public void adicionar(Item item) {
		this.em.persist(item);
	}

	public void remover(int idItem) {
		Item i = this.em.find(Item.class, idItem);
		this.em.remove(i);
	}

	@Remove
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void finalizar() {
		// a simples chamada ao método finalizar() abre uma transação e faz com que o
		// contexto de persistencia seja sincronizado com o banco de dados
		System.out.println("Commit realizado!!!");
	}
}
