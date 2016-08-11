package com.cmsenergy.electricityservice.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessegeDAO {

	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");

	public boolean updateCustomer(int custId, int serviceId) {
		Session session = mySessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update Customer set serviceid = :serviceId where id = :custId");
		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);
		int result = query.executeUpdate();
		System.out.println(result);
		tx.commit();
		

		if (result == 1)
			return true;
		else
			return false;
	}
}
