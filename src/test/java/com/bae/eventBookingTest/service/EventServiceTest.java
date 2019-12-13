package com.bae.eventBookingTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.service.EventService;

@RunWith(SpringRunner.class)
public class EventServiceTest {

	@InjectMocks
	private EventService service;

	@Autowired
	private EventRepository eventRepo;

	private Event testEvent;

	private Event testEventWithID;

	Customer testCustomer = new Customer("Tigs", "Knowles", "tigsye@hotmail.com", "07494398669");

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

	@Before
	public void init() {
		this.testEvent = new Event("HP279NQ", 250, getDate(), this.testCustomer);
		this.eventRepo.deleteAll();
		this.testEventWithID = this.eventRepo.save(this.testEvent);
	}

	@Test
	public void getAllEventsTest() {
		
		List<Event> eventList = new ArrayList<>();
		eventList.add(new Event("HP279NQ", 250, getDate(), this.testCustomer));
		Mockito.when(eventRepo.findAll()).thenReturn(eventList);
		System.out.println(eventList.get(0));
		assertTrue("Returned no users!!", this.service.getAllEvents().size() > 0);
	}

	@Test
	public void addNewEvent() {
		assertThat(this.testEventWithID, this.service.addNewEvent(testEvent, 1L));
	}
	//create customer repo and customer inside and add customer via that ID?

}
