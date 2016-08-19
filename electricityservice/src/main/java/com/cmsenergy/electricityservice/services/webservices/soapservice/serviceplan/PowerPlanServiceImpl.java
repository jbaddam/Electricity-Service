package com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan;

import java.util.List;

import javax.jws.WebService;

import com.cmsenergy.electricityservice.daos.PowerPlanDAO;
import com.cmsenergy.electricityservice.models.ServicePlan;

/**
 * @author Jagan Reddy
 * This has the SOAP service to get the service plans
 * from data base 
 */
@WebService(endpointInterface ="com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan.PowerPlanService",
serviceName="servicePlan")
public class PowerPlanServiceImpl implements PowerPlanService {
	
	/* (non-Javadoc)
	 * @see com.cmsenergy.electricityservice.services.webservices.soapservice.serviceplan.PowerPlanService#getServicePlans()
	 */
	@Override
	public List<ServicePlan> getServicePlans() {
		
		PowerPlanDAO powerPlanDAO = new PowerPlanDAO();
		return powerPlanDAO.getAllPowerPlans();
	}

}
