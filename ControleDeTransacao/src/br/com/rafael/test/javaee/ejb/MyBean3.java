package br.com.rafael.test.javaee.ejb;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
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
public class MyBean3 {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private EJBContext ejbContext;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void mB() {
		Livro l2 = this.em.find(Livro.class, 2);
		l2.setNumeroPaginas(100);
		
		this.ejbContext.setRollbackOnly();
	}
}
