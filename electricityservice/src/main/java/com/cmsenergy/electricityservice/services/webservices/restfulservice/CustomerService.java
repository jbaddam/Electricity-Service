package com.cmsenergy.electricityservice.services.webservices.restfulservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cmsenergy.electricityservice.daos.CustomerDAO;
import com.cmsenergy.electricityservice.models.Customer;

@Path("/customer")
public class CustomerService {

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getUserById(@PathParam("id") String id) {
		CustomerDAO custDAO = new CustomerDAO();
		Customer customer=custDAO.getCustomerById(Integer.parseInt(id));
		return customer;		
	}
}