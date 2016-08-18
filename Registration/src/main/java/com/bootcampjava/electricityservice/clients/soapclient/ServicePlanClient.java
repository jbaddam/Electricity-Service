package com.bootcampjava.electricityservice.clients.soapclient;

import java.util.List;

import com.bootcampjava.electricityservice.soapservice.PowerPlanService;
import com.bootcampjava.electricityservice.soapservice.ServicePlan_Service;
import com.bootcampjava.electricityservice.soapservice.ServicePlan;

/**
 * @author Jagan Reddy
 * This class has a functionality to get all the service plans
 * 
 */
public class ServicePlanClient {

	/**
	 * @return
	 * This method will return the list of service plans
	 * after it processed the SOAP Call
	 */
	public List<ServicePlan> getServicePlans() {
		
		ServicePlan_Service service = new ServicePlan_Service();
		PowerPlanService powerPlans = service.getPowerPlanServiceImplPort();
		return powerPlans.getServicePlans();
	}
}
