package com.bootcampjava.electricityservice.services.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bootcampjava.electricityservice.clients.restclient.CustomerClient;
import com.bootcampjava.electricityservice.clients.soapclient.ServicePlanClient;
import com.bootcampjava.electricityservice.daos.registration.RegistrationDAO;
import com.bootcampjava.electricityservice.jms.MessageSender;
import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.soapservice.Service;

public class RegistrationService {

	@Autowired
	RegistrationDAO regDAO;

	@Autowired
	CustomerClient custClient;

	@Autowired
	ServicePlanClient serviceClient;

	@Autowired
	MessageSender messageSender;

	@Transactional
	public String saveCustomer(Customer customer) {
		int custId = regDAO.saveCustomer(customer);

		String messege = null;
		if (custId != 0) {

			Customer cust = custClient.getCustomerById(custId);

			System.out.println(cust.toString());

			List<Service> servicePlansList = serviceClient.getServicePlans();

			System.out.println(servicePlansList.get(1).getServiceName());

			messageSender.sendMessage(custId + ":" + servicePlansList.get(2).getServiceId());
			
		 messege = "Your Service plan name "+ servicePlansList.get(1).getServiceName()+" & Validity "+servicePlansList.get(1).getValidity()+" Months ";
			return messege;
		} else {
			return messege;
		}
	}
}
