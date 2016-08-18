package com.bootcampjava.electricityservice.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.bootcampjava.electricityservice.clients.restclient.CustomerClient;
import com.bootcampjava.electricityservice.models.registration.Customer;


public class CustomerServiceTest {
	
	private static CustomerClient custClient = Mockito.mock(CustomerClient.class);
	private static  Customer customer;

	@Test
	public void testgetCustomerDetailsById(){
		
		customer = new Customer();
		customer.setCid(7);
		customer.setFirstname("Jagan Reddy");
		customer.setLastname("Baddam");
		customer.setUsername("Jagan_reddy44");
		customer.setPassword(".jagan$reddy.@");
		
		when(custClient.getCustomerById(7)).thenReturn(customer);
		
		Customer cust = custClient.getCustomerById(7);
		assertEquals(customer, cust);
		
	}
	
	
}

