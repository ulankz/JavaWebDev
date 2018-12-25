package io.javaee.hibernateDemo.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.javaee.hibernateDemo.dto.Address;
import io.javaee.hibernateDemo.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Mike");
		user.setWorkAddress("Zhandossov 36/76");
		user.setJoinedDate(new Date());
		user.setDescription("Description of the user goes here");
		Address homeAddress = new Address();
		homeAddress.setCity("MEXICO");
		homeAddress.setState("ME");
		homeAddress.setStreet("MALL WAY 389");
		homeAddress.setZipcode("893289");
		//user.setHomeAddress(homeAddress);
		
		Address officeAddress = new Address();
		officeAddress.setCity("NEW YORK CITY");
		officeAddress.setState("NYC");
		officeAddress.setStreet("UNDERGOUND WAY 9990");
		officeAddress.setZipcode("676777");
		//user.setOfficeAddress(officeAddress);
		
		user.getListOfAddresses().add(homeAddress);
		user.getListOfAddresses().add(officeAddress);
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sFactory.openSession();
		session.beginTransaction();
		user = session.get(UserDetails.class,1);
		
		
		System.out.println("\n"+user.toString());
		session.getTransaction().commit();
		session.close();
		sFactory.close();
		
	}

}
