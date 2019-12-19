package com.bae.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository eventRepo;

	private CustomerRepository customerRepo;
	
	private ValidationService validator = new ValidationService();

	public EventService(EventRepository eventRepo, CustomerRepository customerRepo) {
		this.eventRepo = eventRepo;
		this.customerRepo = customerRepo;
	}
	
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		validator.eventPostcodeValidation(eventToAdd);
		validator.eventCapacityValidation(eventToAdd);
		validator.eventDateValidation(eventToAdd);
		eventToAdd.setCustomer(this.customerRepo.findById(custid)
				.orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist")));
		return eventRepo.save(eventToAdd);
	}

	public String deleteEvent(Long primaryKeyOfEvent) {
		eventRepo.deleteById(primaryKeyOfEvent);
		return "Event deleted successfully.";
	}

	public Event findEventByID(Long eventId) {
		return this.eventRepo.findById(eventId).orElseThrow(() -> new EntityNotFoundException("Event Does Not Exist"));
	}

	public Event updateEvent(Event eventToAdd, Long eventId) {
		validator.eventPostcodeValidation(eventToAdd);
		validator.eventCapacityValidation(eventToAdd);
		validator.eventDateValidation(eventToAdd);
		Event toUpdate = findEventByID(eventId);
		toUpdate.setEventCapacity(eventToAdd.getEventCapacity());
		toUpdate.setEventDate(eventToAdd.getEventDate());
		toUpdate.setEventPostcode(eventToAdd.getEventPostcode());
		return this.eventRepo.save(toUpdate);

	}
}
