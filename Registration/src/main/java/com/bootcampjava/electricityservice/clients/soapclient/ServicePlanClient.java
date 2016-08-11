package com.bootcampjava.electricityservice.clients.soapclient;

import java.util.List;

import com.bootcampjava.electricityservice.soapservice.PowerPlanService;
import com.bootcampjava.electricityservice.soapservice.Service;
import com.bootcampjava.electricityservice.soapservice.Serviceplan;
public class ServicePlanClient {
	
	
	
	
	public  List<Service> getServicePlans(){
		Serviceplan service = new Serviceplan();
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
