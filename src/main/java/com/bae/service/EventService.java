package com.bae.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository repo;

	private CustomerRepository customerRepo;

	public EventService(EventRepository repo, CustomerRepository customerRepo) {
		this.repo = repo;
		this.customerRepo = customerRepo;
	}

	public List<Event> getAllEvents() {
		return repo.findAll();
	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		eventToAdd.setCustomer(this.customerRepo.findById(custid).orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist")));
		return repo.save(eventToAdd);
	}

	public String deleteEvent(Long primaryKeyOfEvent) {
		repo.deleteById(primaryKeyOfEvent);
		return "Event deleted successfully.";
	}
}
