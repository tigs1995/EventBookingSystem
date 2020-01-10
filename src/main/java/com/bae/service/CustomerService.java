package com.bae.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;

@Service
public class CustomerService {
	
	private CustomerRepository customerRepo;
	
	private ValidationService validator = new ValidationService();
	
	@Autowired
	private EventRepository eventRepo;

	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
	
	public Customer addNewCustomer(Customer customerToAdd){
		validator.customerEmailValidation(customerToAdd);
		validator.customerPhoneValidation(customerToAdd);
		validator.customerFirstNameValidation(customerToAdd);
		validator.customerLastNameValidation(customerToAdd);
		return customerRepo.save(customerToAdd);
	}
	
	public String deleteCustomer(Long primaryKeyOfCustomer){
		for (Event event : this.eventRepo.findAll()) {
			this.eventRepo.delete(event);
		}
		this.customerRepo.deleteById(primaryKeyOfCustomer);
		return "Customer deleted successfully.";
	}
	
	public Customer findCustomerByID(Long customerId) {
		return this.customerRepo.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist"));
	}
	
	public Customer updateCustomer(Customer customerToAdd, Long customerId) {
		validator.customerEmailValidation(customerToAdd);
		validator.customerPhoneValidation(customerToAdd);
		validator.customerFirstNameValidation(customerToAdd);
		validator.customerLastNameValidation(customerToAdd);
		Customer updatedCustomer = findCustomerByID(customerId);
		updatedCustomer.setEmail(customerToAdd.getEmail());
		updatedCustomer.setPhone(customerToAdd.getPhone());
		updatedCustomer.setFirstName(customerToAdd.getFirstName());
		updatedCustomer.setLastName(customerToAdd.getLastName());
		return this.customerRepo.save(updatedCustomer);
		
	}

	public boolean checkExisting(Long custid) {
		return this.customerRepo.existsById(custid);
	}

	
	
}
	
	

