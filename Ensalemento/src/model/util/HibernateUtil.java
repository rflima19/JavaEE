package model.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;
	
	static {
		Configuration confg = new Configuration().configure();
		HibernateUtil.sf = confg.buildSessionFactory();
	}
	
	public static Session getSession() {
		return HibernateUtil.sf.getCurrentSession();
	}
	
	public static void beginTransaction() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
	}
	
	public static void commitTransaction() {
		Session session = HibernateUtil.getSession();
		session.getTransaction().commit();
	}
	
	public static void rollbackTransaction() {
		Session session = HibernateUtil.getSession();
		session.getTransaction().rollback();
	}
}
