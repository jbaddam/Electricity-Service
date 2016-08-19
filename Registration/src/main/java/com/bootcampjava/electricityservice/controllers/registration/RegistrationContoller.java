package com.bootcampjava.electricityservice.controllers.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcampjava.electricityservice.models.registration.Customer;
import com.bootcampjava.electricityservice.services.registration.RegistrationService;

/**
 * @author Jagan Reddy
 * This class has 
 */
@Controller
public class RegistrationContoller {

	@Autowired
	RegistrationService regSercice;

	@RequestMapping("/registration")
	public String registration(@ModelAttribute("customer") Customer customer, Model model) {

		String messege = regSercice.registerCustomer(customer);
		
		if (messege != null) {
			model.addAttribute("planinfo",messege);
			return "success";
		} else
			return "fail";
	}
}