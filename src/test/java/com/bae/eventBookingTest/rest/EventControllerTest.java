// package com.bae.eventBookingTest.rest;

// import static org.junit.Assert.assertEquals;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import com.bae.persistence.domain.Customer;
// import com.bae.persistence.domain.Event;
// import com.bae.persistence.repository.CustomerRepository;
// import com.bae.persistence.repository.EventRepository;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class EventControllerTest {


// 	@Autowired
// 	private MockMvc mock;
	
// 	@Autowired
// 	private EventRepository eventRepo;
	
// 	@Autowired
// 	private CustomerRepository custRepo;
	
// 	private Event testEvent = new Event("HP28 9WQ", 250, LocalDate.of(2020, 12, 19));
// 	private Event testEventWithID;
// 	private Long custId;
// 	private Long eventId;
// 	Customer dummyCustomer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "01928374859");

// 	private ObjectMapper mapper = new ObjectMapper();

// 	@Before
// 	public void init() {
// 		this.eventRepo.deleteAll();
// 		this.mapper.registerModule(new JavaTimeModule());
// 		this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
// 		custRepo.save(dummyCustomer);
// 		this.testEventWithID = this.eventRepo.save(testEvent);
// 		this.eventId = testEventWithID.getEventId();
// 		dummyCustomer.setCustomerId(1L);
// 	}
	
// //	@Test
// //	public void testAddEvent() throws Exception{
// //		this.custId = this.dummyCustomer.getCustomerId();
// //
// //		this.testEvent.setCustomer(dummyCustomer);
// //		String result = this.mock.perform(
// //				request(HttpMethod.POST, "/app/event/" + this.custId)
// //				.accept(MediaType.APPLICATION_JSON)
// //				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(testEvent)))
// //				.andExpect(status().isOk())
// //				.andReturn()
// //				.getResponse()
// //				.getContentAsString();
// //		
// //
// //		assertEquals(this.mapper.writeValueAsString(testEventWithID), result);
// //	}

// 	@Test
// 	public void testGetAllEvents() throws Exception {
// 		List<Event> eventList = new ArrayList<>();
// 		eventList.add(this.testEventWithID);

// 		String result = this.mock.perform(request(HttpMethod.GET, "/app/event").accept(MediaType.APPLICATION_JSON))
// 				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
// 		assertEquals(this.mapper.writeValueAsString(eventList), result);
// 	}

// 	@Test
// 	public void testDeleteEvent() throws Exception {
// 		this.mock.perform(request(HttpMethod.DELETE, "/app/event/" + this.eventId)).andExpect(status().isOk());
// 	}
	
// 	@Test
// 	public void testUpdateEvent() throws Exception{
// 		Event newEventDetails = new Event("HP54 9JW", 250, LocalDate.of(2020, 12, 19));
// 		Event updatedEvent = new Event(newEventDetails.getEventPostcode(), newEventDetails.getEventCapacity(), newEventDetails.getEventDate());
// 		updatedEvent.setEventId(this.eventId);
		
// 		String result = this.mock.perform(request(HttpMethod.PUT, "/app/event/" + this.eventId).accept(MediaType.APPLICATION_JSON)
// 				.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newEventDetails)))
// 				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
// 		assertEquals(this.mapper.writeValueAsString(updatedEvent), result);
// 	}

// }
