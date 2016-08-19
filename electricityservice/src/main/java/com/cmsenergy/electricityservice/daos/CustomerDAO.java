package com.cmsenergy.electricityservice.daos;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cmsenergy.electricityservice.models.Customer;

/**
 * @author Jagan Reddy
 * This class has a functionality to 
 * get the customer details
 */
@Repository
public class CustomerDAO {
	final static Logger logger = Logger.getLogger(CustomerDAO.class);


	ApplicationContext context = new ClassPathXmlApplicationContext("contextservlet.xml");
	SessionFactory mySessionFactory = (SessionFactory) context.getBean("mySessionFactory");

	/**
	 * @param id
	 * @return
	 * this method will return the customer object
	 * based on the given id
	 */
	public Customer getCustomerById(int id) {
     
		Session session = mySessionFactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, id);
		logger.info("Customer retrived successfully\n customer info " + customer.toString());
		return customer;

	}

}
