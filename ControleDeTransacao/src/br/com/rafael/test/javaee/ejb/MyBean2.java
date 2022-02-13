package br.com.rafael.test.javaee.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafael.test.model.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MyBean2 {

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private MyBean3 myBean3;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void mA() {
		Livro l1 = this.em.find(Livro.class, 1);
		l1.setNumeroPaginas(100);
		
		this.myBean3.mB();
	}
}
