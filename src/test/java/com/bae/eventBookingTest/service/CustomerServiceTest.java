package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.service.CustomerService;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService custService;

	@Mock
	private CustomerRepository custRepo;
		
	private Customer dummyCustomer;
	
	private Customer dummyCustomerWithID;

	final Long custId = 1L;
	
	@Before
	public void init() {
		this.custRepo.deleteAll();
		this.dummyCustomer = new Customer("James", "Kiesslinger", "jk@hotmail.com", "07968594856");
		this.dummyCustomerWithID = new Customer(dummyCustomer.getFirstName(), dummyCustomer.getLastName(), dummyCustomer.getCustomerEmail(), dummyCustomer.getCustomerNumber());
		this.dummyCustomerWithID.setCustomerId(custId);
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(this.dummyCustomer);
		when(custRepo.findAll()).thenReturn(customerList);
		assertTrue("Returned no users!!", this.custService.getAllCustomers().size() > 0);
	}

	@Test
	public void addCustomerTest() {
		when(this.custRepo.save(dummyCustomer)).thenReturn(dummyCustomer);
		assertEquals(this.dummyCustomer, this.custService.addNewCustomer(this.dummyCustomer));
	}
	
	@Test
	public void deleteCustomerTest() {
		assertEquals("Customer deleted successfully.", this.custService.deleteCustomer(0l));
	}
	
	@Test
	public void updateCustomerTest() {
		Customer newCustomerDetails = new Customer("Tigs", "Knowles", "tigs@msn.com", "07182738495");
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getCustomerEmail(), newCustomerDetails.getCustomerNumber());
		updatedCustomer.setCustomerId(this.custId);
		
		when(this.custRepo.findById(this.custId)).thenReturn(Optional.of(this.dummyCustomerWithID));
		when(this.custRepo.save(updatedCustomer)).thenReturn(updatedCustomer);
		assertEquals(updatedCustomer, this.custService.updateCustomer(newCustomerDetails, this.custId));
	}
	
	

}
