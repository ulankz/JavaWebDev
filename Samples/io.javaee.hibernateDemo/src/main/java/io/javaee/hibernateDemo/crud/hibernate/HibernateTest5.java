package io.javaee.hibernateDemo.crud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.javaee.hibernateDemo.crud.dto.UserDetails;

public class HibernateTest5 {

	public static void main(String[] args) {
	
		
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		UserDetails user = session.get(UserDetails.class, 8);
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated username after session close");
		
		session = sFactory.openSession();
		session.beginTransaction();
		user.setUserName("Selected before update");
		
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
	}

}
