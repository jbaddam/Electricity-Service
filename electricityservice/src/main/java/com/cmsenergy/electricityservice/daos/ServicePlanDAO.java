package com.cmsenergy.electricityservice.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServicePlanDAO {

	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");

	public boolean updateCustomer(int custId, int serviceId) {
		Session session = mySessionFactory.openSession();

		Query query = session.createQuery("update Customer set serviceid = :serviceId where id = :custId");
		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);
		int result = query.executeUpdate();

		if (result == 1)
			return true;
		else
			return false;
	}
}
