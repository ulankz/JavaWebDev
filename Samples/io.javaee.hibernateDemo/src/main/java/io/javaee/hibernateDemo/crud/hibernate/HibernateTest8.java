package io.javaee.hibernateDemo.crud.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import io.javaee.hibernateDemo.crud.dto.UserDetails;

public class HibernateTest8 {

	public static void main(String[] args) {
	
		
		
		SessionFactory sFactory = new Configuration().configure().buildSessionFactory();
		Session session = sFactory.openSession();
		
		session.beginTransaction();
		int minUserID = 5;
		String sqlInj = " 5 or 5=5";
		String userName = "MANOOJ";
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<UserDetails> criteria = builder.createQuery(UserDetails.class);
		Root<UserDetails> root = criteria.from(UserDetails.class);
		ParameterExpression<Integer> uid = builder.parameter(Integer.class);
		criteria.select(root);
		
		
		Predicate greaterThan = builder.gt(root.<Integer>get("userID"), uid);
		criteria.where(builder.equal(root.get("userName"), "MANOOJ"));
		
		criteria.where(greaterThan);
		
		criteria.orderBy(builder.asc(root.get("userName")));
		
		Query<UserDetails> query = session.createQuery(criteria);
		query.setParameter(uid, minUserID);
		
		List<UserDetails> users = query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails m: users) {
			System.out.println(m.getUserName());
		}
			
	}

}
