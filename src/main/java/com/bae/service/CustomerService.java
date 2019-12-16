package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}
	
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	public Customer addNewCustomer(Customer customerToAdd){
		return repo.save(customerToAdd);
	}
	
	public String deleteCustomer(Long primaryKeyOfCustomer){
		this.repo.deleteById(primaryKeyOfCustomer);
		return "Customer deleted successfully.";
	}

	
	
	
}
	
	

