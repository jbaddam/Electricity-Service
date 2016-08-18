package com.bootcampjava.electricityservice.daos.registration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcampjava.electricityservice.models.registration.Customer;

@Repository
public class RegistrationDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	public int saveCustomer(Customer customer) {
		Session session = mySessionFactory.openSession();
		int custId = (Integer) session.save(customer);
		return custId;
	}
}
