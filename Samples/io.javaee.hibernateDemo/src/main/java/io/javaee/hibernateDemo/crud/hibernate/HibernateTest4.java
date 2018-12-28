package io.javaee.hibernateDemo.crud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.javaee.hibernateDemo.crud.dto.UserDetails;

public class HibernateTest4 {

	public static void main(String[] args) {
	
		
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
// CREATE
//		for(int i = 0; i < 10; i++) {
//			UserDetails user = new UserDetails();
//			user.setUserName("User " + i);
//			session.save(user);
//		}
		
// SELECT
		UserDetails user = session.get(UserDetails.class, 5);
		//System.out.println(user.toString());

// DELETE
		//session.delete(user);
// UPDATE
//		user.setUserName("MANOOJ");
//		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
		
		
		
	}

}
