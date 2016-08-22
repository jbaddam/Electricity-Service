package com.cmsenergy.electricityservice.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Jagan Reddy
 * This class has a functionality to 
 * Update the service id to customer details in data base
 */

public class ServicePlanDAO {

	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");

	/**
	 * @param custId
	 * @param serviceId
	 * @return
	 * This method will return true if successfully update 
	 * service id to customer details in data base
	 */
	public boolean updateCustomer(int custId, int serviceId) {
		
		Session session = mySessionFactory.openSession();

		Query query = session.createQuery("update Customer set serviceid = :serviceId where id = :custId");
		query.setParameter("serviceId", serviceId);
		query.setParameter("custId", custId);
		int result = query.executeUpdate();
		session.close();

		if (result == 1)
			return true;
		else
			return false;
	}
}
