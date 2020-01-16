package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> mergefix
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
<<<<<<< HEAD
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.service.CustomerService;
import com.bae.service.ValidationService;
=======
import com.bae.persistence.repository.CustomerRepository;
import com.bae.service.CustomerService;
>>>>>>> mergefix

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService custService;

	@Mock
	private CustomerRepository custRepo;
<<<<<<< HEAD
	
	@Mock
	private ValidationService validator;
	
	@Mock
	private EventRepository eventRepo;
=======
>>>>>>> mergefix
		
	private Customer dummyCustomer;
	
	private Customer dummyCustomerWithID;
<<<<<<< HEAD
	
	List<Event> eventList = new ArrayList<Event>();
	
	Event event = new Event("HP54 9JW", 250, LocalDate.of(2023, 12, 02));
=======
>>>>>>> mergefix

	final Long custId = 1L;
	
	@Before
	public void init() {
		this.custRepo.deleteAll();
<<<<<<< HEAD
		this.dummyCustomer = new Customer("James", "Kiesslinger", "jkeisslinger@hotmail.com", "07493849586");
		this.dummyCustomerWithID = new Customer(dummyCustomer.getFirstName(), dummyCustomer.getLastName(), dummyCustomer.getEmail(), dummyCustomer.getPhone());
=======
		this.dummyCustomer = new Customer("James", "Kiesslinger", "jkeisslinger@hotmail.com", "+1 (480) 848-1398");
		this.dummyCustomerWithID = new Customer(dummyCustomer.getFirstName(), dummyCustomer.getLastName(), dummyCustomer.getCustomerEmail(), dummyCustomer.getCustomerNumber());
>>>>>>> mergefix
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
<<<<<<< HEAD
		this.event.setCustomer(this.dummyCustomerWithID);
		this.event.setEventId(1L);
		this.eventList.add(this.event);
		when(this.eventRepo.findAll()).thenReturn(this.eventList);
		assertEquals("Customer deleted successfully.", this.custService.deleteCustomer(1L));
=======
		assertEquals("Customer deleted successfully.", this.custService.deleteCustomer(0l));
>>>>>>> mergefix
	}
	
	@Test
	public void updateCustomerTest() {
		Customer newCustomerDetails = new Customer("Tigs", "Knowles", "tigs@msn.com", "+44 7182938495");
<<<<<<< HEAD
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getEmail(), newCustomerDetails.getPhone());
=======
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getCustomerEmail(), newCustomerDetails.getCustomerNumber());
>>>>>>> mergefix
		updatedCustomer.setCustomerId(this.custId);
		
		when(this.custRepo.findById(this.custId)).thenReturn(Optional.of(this.dummyCustomerWithID));
		when(this.custRepo.save(updatedCustomer)).thenReturn(updatedCustomer);
		assertEquals(updatedCustomer, this.custService.updateCustomer(newCustomerDetails, this.custId));
	}
	
	

}
