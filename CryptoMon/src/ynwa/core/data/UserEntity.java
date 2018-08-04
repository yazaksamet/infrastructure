package ynwa.core.data;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ynwa.core.entity.User;

public class UserEntity extends DbEntity<User> {

	@Override
	public void ValidateSave(User entity) {
		
	}

	@Override
	public String GetSelectAllQuery() {
		return "from User";
	}

	@Override
	public String GetSelectSingleQuery() {
		return "from User where user_id=:n";
	}
	
	public User GetUserWithPassword(String loginName, String password) {
		String query = "from User where login_name=:n and password=:p";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query selectQuery = session.createQuery( query );
		selectQuery.setParameter("n", loginName);
		selectQuery.setParameter("p", password);
		List<User> result = selectQuery.list();
		session.getTransaction().commit();
		session.close();
		return result.size() > 0 ? result.get(0) : null;
	}

}
