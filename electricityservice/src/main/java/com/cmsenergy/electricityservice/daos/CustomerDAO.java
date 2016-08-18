package com.cmsenergy.electricityservice.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cmsenergy.electricityservice.models.Customer;

@Repository
public class CustomerDAO {

	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");

	public Customer getCustomerById(int id) {

		Session session = mySessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		return customer;

	}

}
