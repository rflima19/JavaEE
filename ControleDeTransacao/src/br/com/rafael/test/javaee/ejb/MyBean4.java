package br.com.rafael.test.javaee.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import br.com.rafael.test.model.Livro;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyBean4 {

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	public void mA() {
		List<Livro> livros = this.em.createQuery("SELECT l FROM Livro l ORDER BY l.id", Livro.class).getResultList();

		for (Livro l : livros) {

			try {
				ut.begin();

				l.setTitulo("???");
				this.em.merge(l);

				if (l.getId() == 3) {
					ut.rollback();
					continue;
				}

				ut.commit();
			} catch (NotSupportedException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (RollbackException e) {
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				e.printStackTrace();
			}
		}
	}
}
