package com.bae.eventBookingTest.rest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	private Customer testCustomer;
	private Customer testCustomerWithID;
	private Long custId;

	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void init() {
		this.customerRepo.deleteAll();
		this.testCustomer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "+447192938495");
		this.testCustomerWithID = this.customerRepo.save(testCustomer);
		this.custId = this.testCustomerWithID.getCustomerId();
	}
	
	@Test
	public void testAddCustomer() throws Exception{
		String result = this.mock.perform(request(HttpMethod.POST, "/app/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(testCustomerWithID))
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testCustomerWithID.getCustomerId()), result);
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
	
//	@Test
//	public void testDeleteCustomer() throws Exception {
////		this.mock.perform(request(HttpMethod.DELETE, "/app/customer/" + this.custId)).andExpect(status().isOk());
//	}
	
	@Test
	public void testUpdateCustomer() throws Exception{
		Customer newCustomerDetails = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "+447192938495");
		Customer updatedCustomer = new Customer(newCustomerDetails.getFirstName(), newCustomerDetails.getLastName(), newCustomerDetails.getEmail(), newCustomerDetails.getPhone());
		updatedCustomer.setCustomerId(this.custId);
		
		String result = this.mock.perform(request(HttpMethod.PUT, "/app/customer/" + this.custId).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newCustomerDetails)))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(updatedCustomer), result);
	}

}
