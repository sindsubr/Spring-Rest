package org.sindu.restapi.controller;

import org.sindu.restapi.entity.CustomUserDetails;
import org.sindu.restapi.service.CustomerServiceRestClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	@Autowired
	CustomerServiceRestClientImpl customerServiceRestClientImpl;
	
	@GetMapping("/login")
	public String login(Model model) {
		CustomUserDetails customUserDetails = new CustomUserDetails();
		model.addAttribute("customUserDetails", customUserDetails);
		return "login";
	}
	
	@PostMapping("/getUserDetails")
	public String login(@ModelAttribute("customUserDetails") CustomUserDetails customUserDetails) {
		System.out.println(customUserDetails.getPassword());
		customerServiceRestClientImpl.setCustomUserDetails(customUserDetails);
		return "redirect:customer/list";
	}

	@PostMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}

}
