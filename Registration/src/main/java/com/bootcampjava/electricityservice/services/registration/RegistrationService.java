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

	@Transactional
	public String saveCustomer(Customer customer) {
		int custId = regDAO.saveCustomer(customer);

		String messege = null;
		if (custId != 0) {
			logger.info("Customer Saved Sccessfully with id " + custId);

			Customer cust = custClient.getCustomerById(custId);

			logger.info("REST call successfully got the customer " + cust.toString());

			List<ServicePlan> servicePlansList = serviceClient.getServicePlans();

			logger.info("SOAP call successfully got the Serviceplans ");

			messageSender.sendMessage(custId + ":" + servicePlansList.get(2).getServiceId());

			messege = "Name " + servicePlansList.get(2).getServiceName() + " & Validity "
					+ servicePlansList.get(2).getValidity() + " Months ";

			return messege;
		} else {
			return messege;
		}
	}
}
