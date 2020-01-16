package com.bae.eventBookingTest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
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
import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.service.EventService;
<<<<<<< HEAD
import com.bae.service.ValidationService;
=======
>>>>>>> mergefix

@RunWith(SpringRunner.class)
public class EventServiceTest {

	@InjectMocks
	private EventService eventService;

	@Mock
	private EventRepository eventRepo;

	@Mock
	private CustomerRepository custRepo;
	
<<<<<<< HEAD
	@Mock
	private ValidationService validator;
	
=======
>>>>>>> mergefix
	private Event dummyEvent;
	
	private Event dummyEventWithID;
	
	final Long eventId = 1L;

	Customer dummyCustomer = new Customer("Tigs", "Knowles", "jkeisslinger@gmail.com", "01928374859");

	@Before
	public void init() {
		this.eventRepo.deleteAll();
		this.dummyEvent = new Event("HP54 9JW", 250, LocalDate.of(2023, 12, 02));
		this.dummyEventWithID = new Event(dummyEvent.getEventPostcode(), dummyEvent.getEventCapacity(), dummyEvent.getEventDate());
		this.dummyEventWithID.setEventId(eventId);
	}

	@Test
	public void getAllEventsTest() {
		List<Event> eventList = new ArrayList<>();
		eventList.add(this.dummyEvent);
		when(eventRepo.findAll()).thenReturn(eventList);
		assertTrue("Returned no users!!", this.eventService.getAllEvents().size() > 0);
	}

	@Test
	public void addEventTest() {
		dummyCustomer.setCustomerId(1L);
		when(this.custRepo.findById(1L)).thenReturn(Optional.of(dummyCustomer));
		when(this.eventRepo.save(dummyEvent)).thenReturn(dummyEvent);
		assertEquals(this.dummyEvent, this.eventService.addNewEvent(this.dummyEvent, 1L));
	}

	@Test
	public void deleteEventTest() {
		assertEquals("Event deleted successfully.", this.eventService.deleteEvent(0l));
	}
	
	@Test
	public void updateEventTest() {
		Event newEventDetails = new Event("HP54 9JW", 250, LocalDate.of(2022, 12, 02));
		Event updatedEvent = new Event(newEventDetails.getEventPostcode(), newEventDetails.getEventCapacity(), newEventDetails.getEventDate());
		updatedEvent.setEventId(this.eventId);
		
		when(this.eventRepo.findById(this.eventId)).thenReturn(Optional.of(this.dummyEventWithID));
		when(this.eventRepo.save(updatedEvent)).thenReturn(updatedEvent);
		assertEquals(updatedEvent, this.eventService.updateEvent(newEventDetails, this.eventId));
	}

}
