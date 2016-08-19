package com.bootcampjava.electricityservice.services.registration;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcampjava.electricityservice.clients.restclient.CustomerClient;
import com.bootcampjava.electricityservice.clients.soapclient.ServicePlanClient;
import com.bootcampjava.electricityservice.daos.registration.RegistrationDAO;
import com.bootcampjava.electricityservice.jms.MessageSender;
import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.soapservice.ServicePlan;

/**
 * @author Jagan Reddy
 * This class has a functionality to register the customer
 */
public class RegistrationService {

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	CustomerClient custClient;

	@Autowired
	ServicePlanClient serviceClient;

	@Autowired
	MessageSender messageSender;
	
	final static Logger logger = Logger.getLogger(RegistrationService.class);

	/**
	 * @param customer
	 * @return
	 * registerCustomer method will return a message with details of service plan
	 * while registering the customer, 
	 * it consumes SOAP service to get all the service plans,REST service to get the customer details
	 * and sends asynchronous JMS message to update the customer information with serviceId in the database
	 */
	@Transactional
	public String registerCustomer(Customer customer) {
		
		int custId = regDAO.saveCustomer(customer);

		String messege = null;
		if (custId != 0) {
			logger.info("Customer Saved Sccessfully with id " + custId);

			// Making REST call to get the customer Details
			Customer cust = custClient.getCustomerById(custId);

			logger.info("REST call successfully got the customer " + cust.toString());
			
			//Making SOAP call to get all the service plans
			List<ServicePlan> servicePlansList = serviceClient.getServicePlans();

			logger.info("SOAP call successfully got the Serviceplans ");
			
			//sending JMS message by passing the CustomerID and ServiceID to update the customer details with serviceID 
			messageSender.sendMessage(custId + ":" + servicePlansList.get(2).getServiceId());

			messege = "Name " + servicePlansList.get(2).getServiceName() + " & Validity "
					+ servicePlansList.get(2).getValidity() + " Months ";

			return messege;
		} else {
			return messege;
		}
	}
}
