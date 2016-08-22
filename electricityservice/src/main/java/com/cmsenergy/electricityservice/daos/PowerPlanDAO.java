package com.cmsenergy.electricityservice.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cmsenergy.electricityservice.models.ServicePlan;

/**
 * @author Jagan Reddy
 * This class has a functionality to 
 * get all the service plans and their details
 */

@Repository
public class PowerPlanDAO {

	
	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory= (SessionFactory) context.getBean("mySessionFactory");
		
	/**
	 * @return
	 * This method will return the list of service plans
	 */
	public List<ServicePlan> getAllPowerPlans() {
		
		Session session = mySessionFactory.openSession();
		List<ServicePlan> services = session.createCriteria(ServicePlan.class).list();
		session.close();
		return services;
	}

}
