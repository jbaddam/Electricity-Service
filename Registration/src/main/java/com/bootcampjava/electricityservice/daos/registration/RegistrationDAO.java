package com.bootcampjava.electricityservice.daos.registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcampjava.electricityservice.models.registration.Customer;

/**
 * @author Jagan Reddy 
 * This class has a functionality to 
 * store the customer details in database
 */
@Repository
public class RegistrationDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	/**
	 * @param customer
	 * @return
	 * This method will return the customerId
	 * once it successfully stored the customer in database
	 */
	public int saveCustomer(Customer customer) {
		
		Session session = mySessionFactory.openSession();
		int custId = (Integer) session.save(customer);
		session.close();
		return custId;
	}
}
