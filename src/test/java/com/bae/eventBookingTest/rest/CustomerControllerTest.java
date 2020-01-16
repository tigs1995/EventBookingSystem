package com.bae.eventBookingTest.rest;

import static org.junit.Assert.assertEquals;
<<<<<<< HEAD
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
=======
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

>>>>>>> mergefix
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
<<<<<<< HEAD
import org.mockito.Mock;
=======
>>>>>>> mergefix
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistence.domain.Customer;
<<<<<<< HEAD
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

=======
import com.bae.persistence.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


>>>>>>> mergefix
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private CustomerRepository customerRepo;
	
<<<<<<< HEAD
	@Autowired
	private EventRepository eventRepo;
	
	private Customer testCustomer;
	private Customer testCustomerWithID;
	private Long custId;
	private Event testEvent;
	private Event testEventWithID;
	private Long eventId;
=======
	private Customer testCustomer;
	private Customer testCustomerWithID;
	private Long custId;
>>>>>>> mergefix

	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void init() {
		this.customerRepo.deleteAll();
<<<<<<< HEAD
		this.eventRepo.deleteAll();
		this.testCustomer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "+447192938495");
		this.testCustomerWithID = this.customerRepo.save(testCustomer);
		this.custId = this.testCustomerWithID.getCustomerId();
		this.testEvent = new Event("HP54 9JW", 250, LocalDate.of(2023, 12, 02));
		this.testEventWithID = this.eventRepo.save(testEvent);
		this.eventId = this.testEventWithID.getEventId();
		this.testEventWithID.setCustomer(this.testCustomerWithID);
	}
	
=======
		this.testCustomer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "+447192938495");
		this.testCustomerWithID = this.customerRepo.save(testCustomer);
		this.custId = this.testCustomerWithID.getCustomerId();
	}
	
	
>>>>>>> mergefix
	@Test
	public void testAddCustomer() throws Exception{
		String result = this.mock.perform(request(HttpMethod.POST, "/app/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testCustomerWithID))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
<<<<<<< HEAD
		assertEquals(this.mapper.writeValueAsString(testCustomerWithID.getCustomerId()), result);
=======
		assertEquals(this.mapper.writeValueAsString(testCustomerWithID), result);
>>>>>>> mergefix
	}
	
	@Test
	public void testGetAllCustomer() throws Exception{
		List<Customer> customerList = new ArrayList<>();
		customerList.add(this.testCustomerWithID);
		
		String result = this.mock.perform(request(HttpMethod.GET, "/app/customer")
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(customerList), result);
	}
	
<<<<<<< HEAD
//	@Test
//	public void testDeleteCustomer() throws Exception {
//		List<Event> eventList = new ArrayList<>();
//		eventList.add(this.testEventWithID);
//		this.customerRepo.save(this.testCustomerWithID);
//		when(this.eventRepo.findAll()).thenReturn(eventList);
//		String result = this.mock.perform(request(HttpMethod.DELETE, "/app/customer/" + this.testEventWithID.getCustomer().getCustomerId())).andExpect(status().isOk())
//		.andReturn().getResponse().getContentAsString();
//		assertEquals("Customer deleted successfully.", result);
//	}
=======
	@Test
	public void testDeleteCustomer() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/app/customer/" + this.custId)).andExpect(status().isOk());
	}
>>>>>>> mergefix
	
	@Test
	public void testUpdateCustomer() throws Exception{
		Customer newCustomerDetails = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "+447192938495");
<<<<<<< HEAD
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getEmail(), newCustomerDetails.getPhone());
=======
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getCustomerEmail(), newCustomerDetails.getCustomerNumber());
>>>>>>> mergefix
		updatedCustomer.setCustomerId(this.custId);
		
		String result = this.mock.perform(request(HttpMethod.PUT, "/app/customer/" + this.custId).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newCustomerDetails)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(updatedCustomer), result);
	}

}
