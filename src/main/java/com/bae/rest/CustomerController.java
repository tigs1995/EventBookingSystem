package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Customer;
import com.bae.service.CustomerService;

@RestController
@RequestMapping("/app")
public class CustomerController {
	
	private CustomerService service;

	public CustomerController(CustomerService service){  
		this.service = service;
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return service.getAllCustomers();
	}

	@PostMapping("/customer")
	public Customer addNewCustomer(Customer customerToAdd){
		return service.addNewCustomer(customerToAdd);
	}
	
	@DeleteMapping("/customer/{custid}")
	public String deleteCustomer(@PathVariable("custid") Long custId){
		return service.deleteCustomer(custId);
	}


}
