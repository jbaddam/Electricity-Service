package com.cmsenergy.electricityservice.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.cmsenergy.electricityservice.models.ServicePlan;

@Repository
public class PowerPlanDAO {

	
	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory= (SessionFactory) context.getBean("mySessionFactory");
	
	
		
	public List<ServicePlan> getAllPowerPlans() {		
		Session session = mySessionFactory.openSession();
		List<ServicePlan> services = session.createCriteria(ServicePlan.class).list();
		return services;
	}

}
