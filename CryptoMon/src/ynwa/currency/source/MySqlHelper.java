package ynwa.currency.source;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import ynwa.currency.entity.Provider;
import ynwa.currency.entity.User;

public class MySqlHelper implements IStorageHelper {
	
	@Override
	public void InsertProvider(Provider provider) {
		provider.Validate();
		Session session = HibernateUtil.getSessionFactory().openSession();		 
        session.beginTransaction();
        session.save(provider);
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public void UpdateProvider(Provider provider) {
		provider.Validate();
		Session session = HibernateUtil.getSessionFactory().openSession();		 
        session.beginTransaction();
        session.update(provider);
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public void DeleteProvider(Provider provider) {
		Session session = HibernateUtil.getSessionFactory().openSession();		 
        session.beginTransaction();
        session.delete(provider);
        session.getTransaction().commit();
        session.close();
	}

	@Override
	public List<Provider> SelectProviders() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Provider> result = session.createQuery( "from Provider" ).list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public Provider SelectProviderWithName(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query selectQuery = session.createQuery( "from Provider where name=:n" );
		selectQuery.setParameter("n", name);
		List<Provider> result = selectQuery.list();
		session.getTransaction().commit();
		session.close();
		return result.size() > 0 ? result.get(0) : null;
	}

	@Override
	public Provider SelectProvider(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User SelectUser(String loginName, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query selectQuery = session.createQuery( "from User where loginName=:l and password:p" );
		selectQuery.setParameter("l", loginName);
		selectQuery.setParameter("p", password);
		List<User> result = selectQuery.list();
		session.getTransaction().commit();
		session.close();
		return result.size() > 0 ? result.get(0) : null;
	}

}
