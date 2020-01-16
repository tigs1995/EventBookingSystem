package com.bae.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
<<<<<<< HEAD
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
=======
import com.bae.persistence.repository.CustomerRepository;
>>>>>>> mergefix

@Service
public class CustomerService {
	
	private CustomerRepository customerRepo;
<<<<<<< HEAD
	private ValidationService validator;
	private EventRepository eventRepo;
	
	public CustomerService(CustomerRepository customerRepo, EventRepository eventRepo, ValidationService validator ) {
		this.customerRepo = customerRepo;
		this.eventRepo = eventRepo;
		this.validator = validator;
=======
	
	private ValidationService validator = new ValidationService();

	public CustomerService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
>>>>>>> mergefix
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
<<<<<<< HEAD
		for (Event event : this.eventRepo.findAll()	) {
			if (event.getCustomer().getCustomerId().equals(primaryKeyOfCustomer)) {
				this.eventRepo.deleteById(event.getEventId());
			}
		}
=======
>>>>>>> mergefix
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
<<<<<<< HEAD
		updatedCustomer.setEmail(customerToAdd.getEmail());
		updatedCustomer.setPhone(customerToAdd.getPhone());
=======
		updatedCustomer.setCustomerEmail(customerToAdd.getCustomerEmail());
		updatedCustomer.setCustomerNumber(customerToAdd.getCustomerNumber());
>>>>>>> mergefix
		updatedCustomer.setFirstName(customerToAdd.getFirstName());
		updatedCustomer.setLastName(customerToAdd.getLastName());
		return this.customerRepo.save(updatedCustomer);
		
	}

<<<<<<< HEAD
	public boolean checkExisting(Long custid) {
		return this.customerRepo.existsById(custid);
	}

=======
	
>>>>>>> mergefix
	
	
}
	
	

