package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.EventRepository;
import com.bae.service.EventService;

@RunWith(SpringRunner.class)
public class EventServiceTest {

	public Date getDate() {
		String dateString = "12-02-2019";

		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	@InjectMocks
	private EventService eventService;

	@Mock
	private EventRepository eventRepo;
		  
	Event dummyEvent = new Event("HP279NQ", 250, getDate());

	@Before
	public void init() {
		this.eventRepo.deleteAll();
		
	}
	
	@Test
	public void getAllEventsTest() {
		List<Event> eventList = new ArrayList<>();
		eventList.add(this.dummyEvent);
		Mockito.when(eventRepo.findAll()).thenReturn(eventList);
		assertTrue("Returned no users!!", this.eventService.getAllEvents().size() > 0);
	}

	@Test
	public void addEventTest() {
		Mockito.when(this.eventRepo.save(dummyEvent)).thenReturn(dummyEvent);
		assertEquals(this.dummyEvent, this.eventService.addNewEvent(this.dummyEvent, 1L));
	}
	
	
//	@Test
//	public void deleteCustomerTest() {
//		assertEquals("Customer deleted successfully.", this.custService.deleteCustomer(this.dummyCustomerWithID.getCustomerId()));
//	}
	
	

}
