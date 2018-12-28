package io.javaee.hibernateDemo.crud.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.javaee.hibernateDemo.crud.dto.UserDetails;

public class HibernateTest7 {

	public static void main(String[] args) {
	
		
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		int minUserID = 5;
		String sqlInj = " 5 or 5=5";
		String userName = "MANOOJ";
//		Query query = session.getNamedQuery("UserDetails.byID"); 
//		query.setParameter(0, minUserID);
		Query<UserDetails> queryNative = session.getNamedQuery("UserDetails.byName"); 
		queryNative.setParameter(0, userName);
		List<UserDetails> users = queryNative.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails m: users) {
			System.out.println(m.getUserName());
		}
			
	}

}
