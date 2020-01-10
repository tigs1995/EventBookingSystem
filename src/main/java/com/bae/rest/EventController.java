package com.bae.rest;

import com.bae.service.EventService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Event;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class EventController {
	
	private EventService service; 

	public EventController(EventService service){  
		this.service = service;
	}
	
	@GetMapping("/event")
	public List<Event> getAllEvents(){
		return service.getAllEvents();
	}
	
	@GetMapping("/checkExistingEvent/{eventid}")
	public boolean checkExisting(@PathVariable("eventid") Long eventid) {
		return this.service.checkExisting(eventid);
	}
	
	@PostMapping("/event/{custid}")
	public Event addNewEvent(@RequestBody Event eventToAdd, @PathVariable("custid") Long custid){
		return service.addNewEvent(eventToAdd, custid);
	}

	@DeleteMapping("/event/{eventid}")
	public String deleteEvent(@PathVariable("eventid") Long eventId){
		return service.deleteEvent(eventId);
	}
	
	@PutMapping("/event/{eventid}")
	public Event updateEvent(@PathVariable("eventid") Long eventId, @RequestBody Event event) {
		return this.service.updateEvent(event, eventId);
	}


}
