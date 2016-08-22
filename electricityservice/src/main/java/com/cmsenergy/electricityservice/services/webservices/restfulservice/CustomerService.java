package com.cmsenergy.electricityservice.services.webservices.restfulservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cmsenergy.electricityservice.daos.CustomerDAO;
import com.cmsenergy.electricityservice.models.Customer;

/**
 * @author Jagan Reddy
 * This class provides the REST service to get the customer details
 * from data base 
 */
@Path("/customer")
public class CustomerService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicatationcontext.xml");

	/**
	 * @param id
	 * @return
	 * this method will return the customer details
	 * based on the given id
	 */
	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getUserById(@PathParam("id") String id) {
		
		CustomerDAO custDAO = (CustomerDAO)context.getBean("custDAO");
		Customer customer=custDAO.getCustomerById(Integer.parseInt(id));		
		return customer;		
	}
}