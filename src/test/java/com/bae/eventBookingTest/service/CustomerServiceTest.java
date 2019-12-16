package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
		
	Customer dummyCustomer = new Customer("James", "Kiesslinger", "jk@hotmail.com", "07968594856");

	@Before
	public void init() {
		this.custRepo.deleteAll();
	}
	
	@Test
	public void getAllCustomersTest() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(this.dummyCustomer);
		Mockito.when(custRepo.findAll()).thenReturn(customerList);
		System.out.println(customerList.get(0));
		assertTrue("Returned no users!!", this.custService.getAllCustomers().size() > 0);
	}

	@Test
	public void addCustomerTest() {
		Mockito.when(this.custRepo.save(dummyCustomer)).thenReturn(dummyCustomer);
		assertEquals(this.dummyCustomer, this.custService.addNewCustomer(this.dummyCustomer));
	}
	
	@Test
	public void deleteCustomerTest() {
		assertEquals("Customer deleted successfully.", this.custService.deleteCustomer(0l));
	}
	
	

}
