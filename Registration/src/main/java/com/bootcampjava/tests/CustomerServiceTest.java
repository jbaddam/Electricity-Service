package com.bootcampjava.tests;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.bootcampjava.electricityservice.clients.restclient.CustomerClient;
import com.bootcampjava.electricityservice.models.registration.Customer;


public class CustomerServiceTest {
	
	private static CustomerClient custClient;
	private static  Customer customer;
	
	@BeforeClass
	public static void setUp(){
		
		custClient = Mockito.mock(CustomerClient.class);
		customer = new Customer();
		customer.setCid(7);
		customer.setFirstname("Jagan Reddy");
		customer.setLastname("Baddam");
		customer.setUsername("Jagan_reddy44");
		customer.setPassword(".jagan$reddy.@");
		
		when(custClient.getCustomerById(7)).thenReturn(customer);
	
	}
	
	@Test
	public void testgetCustomerDetailsById(){
		
		Customer cust = custClient.getCustomerById(7);
		assertSame(customer, cust);
		
	}
	
}
