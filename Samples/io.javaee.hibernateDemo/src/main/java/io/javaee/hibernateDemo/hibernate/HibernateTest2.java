package io.javaee.hibernateDemo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.javaee.hibernateDemo.dto.UserDetails2;
import io.javaee.hibernateDemo.dto.Vehicle;

public class HibernateTest2 {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();
		user.setUserName("Mike");
		
		Vehicle v1 = new Vehicle();
		v1.setVehicleName("TESLA 999");
		Vehicle v2 = new Vehicle();
		v2.setVehicleName("BWM 7X");
		
		user.getVehicles().add(v1);
		user.getVehicles().add(v2);
//		v1.setUser(user);
//		v2.setUser(user);
		
//		v1.getUsers().add(user);
//		v2.getUsers().add(user);
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
//		session.save(v1);
//		session.save(v2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails2.class,1);
		
		
		System.out.println("\n"+user.toString());
		session.getTransaction().commit();
		session.close();
		sFactory.close();
		
	}

}
