package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository repo;

	public EventService(EventRepository repo) {
		this.repo = repo;

	}
	
	public List<Event> getAllEvents(){
		return repo.findAll();
	}
	
	public Event addNewEvent(Event eventToAdd){
		return repo.save(eventToAdd);
	}
	
	public String deleteEvent(Long primaryKeyOfEvent){
		repo.deleteById(primaryKeyOfEvent);
		return "Event deleted successfully.";
	}
}
