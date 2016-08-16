package com.bootcampjava.electricityservice.clients.soapclient;

import java.util.List;

import com.bootcampjava.electricityservice.soapservice.PowerPlanService;
import com.bootcampjava.electricityservice.soapservice.ServicePlan_Service;
import com.bootcampjava.electricityservice.soapservice.ServicePlan;
public class ServicePlanClient {
	
	
	
	
	public  List<ServicePlan> getServicePlans(){
		ServicePlan_Service service = new ServicePlan_Service();
		PowerPlanService  powerPlans = service.getPowerPlanServiceImplPort();
		return powerPlans.getServicePlans();		
	}
	
	/*public static void main(String[] args) {
		ServicePlanClient c = new ServicePlanClient();
		List <Service> services = c.getServicePlans();
		for(Service service: services){
			System.out.println(service.getServiceName());
		}
	}*/
}
