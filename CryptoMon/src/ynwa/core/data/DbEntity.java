package ynwa.core.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;


public abstract class DbEntity<T> {
	static Logger log = Logger.getLogger(DbEntity.class.getName());
	
	public abstract void ValidateSave(T entity);
	public abstract String GetSelectAllQuery();
	public abstract String GetSelectSingleQuery();
	
	public void Insert(T entity) {
		log.debug("Insert started: " + entity.getClass().getName());
		this.ValidateSave(entity);
		
		Session session = HibernateUtil.getSessionFactory().openSession();		 
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        
        log.debug("Insert completed: " + entity.getClass().getName());
	}
	
	public void Update(T entity) {
		log.debug("update started: " + entity.getClass().getName());
		this.ValidateSave(entity);
		
		Session session = HibernateUtil.getSessionFactory().openSession();		 
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        log.debug("update completed: " + entity.getClass().getName());
	}
	
	public void Delete(T entity) {
		log.debug("delete started: " + entity.getClass().getName());
		this.ValidateDelete(entity);
		
		Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
        log.debug("update completed: " + entity.getClass().getName());
	}
	
	public void ValidateDelete(T entity) {
		
	}
	
	public T Select(String id) {
		String query = this.GetSelectSingleQuery();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query selectQuery = session.createQuery( query );
		selectQuery.setParameter("n", id);
		List<T> result = selectQuery.list();
		session.getTransaction().commit();
		session.close();
		return result.size() > 0 ? result.get(0) : null;
	}
	
	public List<T> SelectAll() {
		String query = this.GetSelectAllQuery();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<T> result = session.createQuery( query ).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
}
