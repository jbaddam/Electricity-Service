package com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan;

import java.util.List;

import javax.jws.WebService;

import com.cmsenergy.electricityservice.daos.PowerPlanDAO;
import com.cmsenergy.electricityservice.models.ServicePlan;

@WebService(endpointInterface ="com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan.PowerPlanService",
serviceName="serviceplan")
public class PowerPlanServiceImpl implements PowerPlanService {
	
	@Override
	public List<ServicePlan> getServicePlans() {
		PowerPlanDAO powerPlanDAO = new PowerPlanDAO();
		return powerPlanDAO.getAllPowerPlans();
	}

}
