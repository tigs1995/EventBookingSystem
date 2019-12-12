package com.bae.rest;

import com.bae.service.EventService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Event;

@RestController
@RequestMapping("/app")
public class EventController {
	
	private EventService service;

	public EventController(EventService service){  
		this.service = service;
	}
	
	@GetMapping("/event")
	public List<Event> getAllEvents(){
		return service.getAllEvents();
	}

	@PostMapping("/event/{custid}")
	public Event addNewEvent(Event eventToAdd){
		return service.addNewEvent(eventToAdd);
	}

	@DeleteMapping("/event/{id}")
	public String deleteEvent(Long primaryKeyOfEvent){
		return service.deleteEvent(primaryKeyOfEvent);
	}


}
