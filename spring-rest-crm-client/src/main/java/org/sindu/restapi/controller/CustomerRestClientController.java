package org.sindu.restapi.controller;

import java.util.List;

import org.sindu.restapi.entity.Customer;
import org.sindu.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerRestClientController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String getCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		if(customer.getId() == 0) {
			customerService.saveCustomer(customer);
		}else {
			customerService.updateCustomer(customer);
		}
		return "redirect:/customer/list";
	}
	@PutMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		// delete the customer
		customerService.deleteCustomer(customerId);
		return "redirect:/customer/list";
	}
}
