package model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import model.util.HibernateUtil;

public abstract class DAO<T> {

	private Session session;
	private Class<T> clazz;
	
	protected DAO(Class<T> clazz) {
		super();
		this.session = HibernateUtil.getSession();
		this.clazz = clazz;
	}
	
	public T load(Serializable id) throws DAOException {
		try {
			return (T) this.session.load(this.clazz, id);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	public void save(T obj) throws DAOException {
		try {
			this.session.save(obj);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	public void delete(T obj) throws DAOException {
		try {
			this.session.delete(obj);
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
	
	protected List<?> list(String hql) throws DAOException {
		try {
			Query<?> query = this.session.createQuery(hql);
			return query.getResultList();
		} catch (HibernateException e) {
			throw new DAOException(e);
		}
	}
}
