package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject customer service
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get customers from service layer
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to model
		model.addAttribute("customers",theCustomers);
		
		return "list-customers";
	} 
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model mode) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		mode.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get Customer from Service layer
		Customer theCustomer = customerService.getCustomer(theId);
		
		// save customer to model to prepopulate form
		theModel.addAttribute("customer", theCustomer);
		//send over our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theMode) {
		customerService.delete(theId);
		return "redirect:/customer/list";
	}
}
