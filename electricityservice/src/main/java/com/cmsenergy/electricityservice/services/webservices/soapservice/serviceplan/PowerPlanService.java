package com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cmsenergy.electricityservice.models.ServicePlan;

@WebService
public interface PowerPlanService {
	@WebMethod
	public List<ServicePlan> getServicePlans();

}
