package io.javaee.hibernateDemo.crud.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.javaee.hibernateDemo.crud.dto.UserDetails;

public class HibernateTest6 {

	public static void main(String[] args) {
	
		
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		int minUserID = 5;
		String sqlInj = " 5 or 5=5";
		String userName = "User 8";
		//Query query = session.createQuery("  from UserDetails where userID > " + sqlInj);
		Query query = session.createQuery("  from UserDetails where userID > ?0 and userName = :username");
		query.setParameter(0, minUserID);
		query.setParameter("username", userName);
//			query.setFirstResult(5);
//			query.setMaxResults(3);
			
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails m: users) {
			System.out.println(m.getUserName());
		}
			
	}

}
