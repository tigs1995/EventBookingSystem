//package com.bae.eventBookingTest.rest;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.mockito.Mockito.when;
//
//import com.bae.persistence.domain.Customer;
//import com.bae.persistence.domain.Event;
//import com.bae.persistence.repository.CustomerRepository;
//import com.bae.persistence.repository.EventRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class EventControllerTest {
//
//	public Date getDate() {
//		String dateString = "12-02-2019";
//
//		Date date = new Da;
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		try {
//			date = sdf.parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
//
//	@Autowired
//	private MockMvc mock;
//
//	@Autowired
//	private EventRepository eventRepo;
//
//	@Autowired
//	private CustomerRepository custRepo;
//
//	private Event testEvent = new Event("HP2718Y", 250, getDate());
//	private Event testEventWithID;
//	private Long custId;
//	private Long eventId;
//	Customer dummyCustomer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "01928374859");
//
//	private ObjectMapper mapper = new ObjectMapper();
//
//	@Before
//	public void init() {
//		this.eventRepo.deleteAll();
//		this.testEventWithID = this.eventRepo.save(testEvent);
//		this.eventId = testEventWithID.getEventId();
//	}
//
////		@Test
////		public void testAddEvent() throws Exception{
////			dummyCustomer.setCustomerId(1L);
////			Mockito.when(this.custRepo.findById(1L)).thenReturn(Optional.of(dummyCustomer));
////			this.custId = this.dummyCustomer.getCustomerId();
////			String result = this.mock.perform(request(HttpMethod.POST, "/app/event/" + this.custId)
////					.contentType(MediaType.APPLICATION_JSON)
////					.content(this.mapper.writeValueAsString(testEventWithID))
////					.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
////					.andReturn().getResponse().getContentAsString();
////			assertEquals(this.mapper.writeValueAsString(testEventWithID), result);
////		}
//
//	@Test
//	public void testGetAllEvents() throws Exception {
//		List<Event> eventList = new ArrayList<>();
//		eventList.add(this.testEventWithID);
//
//		String result = this.mock.perform(request(HttpMethod.GET, "/app/event").accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		assertEquals(this.mapper.writeValueAsString(eventList), result);
//	}
//
//	@Test
//	public void testDeleteEvent() throws Exception {
//		this.mock.perform(request(HttpMethod.DELETE, "/app/event/" + this.eventId)).andExpect(status().isOk());
//	}
//
//}
