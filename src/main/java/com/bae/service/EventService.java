package com.bae.service;

import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.stereotype.Service;

import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository eventRepo;

	private CustomerRepository customerRepo;

	public EventService(EventRepository eventRepo, CustomerRepository customerRepo) {
		this.eventRepo = eventRepo;
		this.customerRepo = customerRepo;
	}

	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		String regexForPostcode = "^[A-Za-z]{1,2}[0-9Rr][0-9A-Za-z]? [0-9][AaBbD-Hd-hJjLlNnP-Up-uW-Zw-z]{2}$";
		Pattern pattern = Pattern.compile(regexForPostcode);
		if (pattern.matcher(eventToAdd.getEventPostcode()).matches() != true) {
			throw new ValidationException("Wrong postcode format.");
		}
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

	public Event updateEvent(Event event, Long eventId) {
		Event toUpdate = findEventByID(eventId);
		toUpdate.setEventCapacity(event.getEventCapacity());
		toUpdate.setEventDate(event.getEventDate());
		toUpdate.setEventPostcode(event.getEventPostcode());
		return this.eventRepo.save(toUpdate);

	}
}
