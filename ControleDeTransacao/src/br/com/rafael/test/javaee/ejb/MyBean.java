package br.com.rafael.test.javaee.ejb;

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
public class MyBean {

	@PersistenceContext
	private EntityManager em;
	
//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
//	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void mA() {
		Livro l1 = this.em.find(Livro.class, 1);
		l1.setNumeroPaginas(100);
		
//		if (l1.getNumeroPaginas() == 100) {
//			throw new RuntimeException("Deu erro!!!");
//		}
		
		Livro l2 = this.em.find(Livro.class, 2);
		l2.setNumeroPaginas(100);
	}
}
