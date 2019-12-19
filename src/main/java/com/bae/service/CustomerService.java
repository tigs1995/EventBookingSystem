package com.bae.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepo;
	
	private ValidationService validator = new ValidationService();

	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer addNewCustomer(Customer customerToAdd){
		validator.customerEmailValidation(customerToAdd);
		return customerRepo.save(customerToAdd);
	}
	
	public String deleteCustomer(Long primaryKeyOfCustomer){
		this.customerRepo.deleteById(primaryKeyOfCustomer);
		return "Customer deleted successfully.";
	}
	
	public Customer findCustomerByID(Long customerId) {
		return this.customerRepo.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist"));
	}
	
	public Customer updateCustomer(Customer customer, Long customerId) {
		validator.customerEmailValidation(customer);
		Customer updatedCustomer = findCustomerByID(customerId);
		updatedCustomer.setCustomerEmail(customer.getCustomerEmail());
		updatedCustomer.setCustomerNumber(customer.getCustomerNumber());
		updatedCustomer.setFirstName(customer.getFirstName());
		updatedCustomer.setLastName(customer.getLastName());
		return this.customerRepo.save(updatedCustomer);
		
	}

	
	
	
}
	
	

