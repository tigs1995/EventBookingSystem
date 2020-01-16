package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Customer;
import com.bae.service.CustomerService;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class CustomerController {
	
	private CustomerService service;

	public CustomerController(CustomerService service){  
		this.service = service;
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(){
		return service.getAllCustomers();
	}
<<<<<<< HEAD
	
	@GetMapping("/checkExistingCust/{custid}")
	public boolean checkExisting(@PathVariable("custid") Long custid) {
		return this.service.checkExisting(custid);
	}
	
	@PostMapping("/customer")
	public Long addNewCustomer(@RequestBody Customer customerToAdd){
		Customer customer = service.addNewCustomer(customerToAdd);
		return customer.getCustomerId();
	}	
=======

	@PostMapping("/customer")
	public Customer addNewCustomer(@RequestBody Customer customerToAdd){
		return service.addNewCustomer(customerToAdd);
	}
>>>>>>> mergefix
	
	@DeleteMapping("/customer/{custid}")
	public String deleteCustomer(@PathVariable("custid") Long custId){
		return service.deleteCustomer(custId);
	}
	
	@PutMapping("/customer/{custid}")
	public Customer updateCustomer(@PathVariable("custid") Long custId, @RequestBody Customer customer) {
		return this.service.updateCustomer(customer, custId);
	}


}
