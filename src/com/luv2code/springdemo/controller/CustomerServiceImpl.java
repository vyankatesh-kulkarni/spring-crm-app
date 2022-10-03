package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	// need to inject customer DAO
	@Autowired
	CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
		
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Customer theCustomer = customerDAO.getCustomer(theId);
		return theCustomer;
	}


	@Override
	@Transactional
	public void delete(int theId) {
		customerDAO.delete(theId);
		
	}

}
