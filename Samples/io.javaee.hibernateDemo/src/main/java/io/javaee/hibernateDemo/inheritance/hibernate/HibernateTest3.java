package io.javaee.hibernateDemo.inheritance.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import io.javaee.hibernateDemo.inheritance.dto.Vehicle;
import io.javaee.hibernateDemo.inheritance.dto.FourWheeler;
import io.javaee.hibernateDemo.inheritance.dto.TwoWheeler;

public class HibernateTest3 {

	public static void main(String[] args) {
	
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("TESLA 999");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("CENTURION MTB");
		bike.setSteeringHandle("FRONT STEERING HANDLE");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("BMW X7");
		car.setSteeringWheel("BMW STEERING WHEEL");
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);

		session.getTransaction().commit();
		session.close();
		
		
		
		
	}

}
