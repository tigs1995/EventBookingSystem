package com.bae.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository eventRepo;

	private CustomerRepository customerRepo;
	
	private Customer customer = new Customer();
	
	private String email;
	
	private ValidationService validator = new ValidationService();

	@Autowired
	private JavaMailSender javaMailSender;

	public EventService(EventRepository eventRepo, CustomerRepository customerRepo) {
		this.eventRepo = eventRepo;
		this.customerRepo = customerRepo;
	}

	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	public void sendEmail(String email) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		validator.eventPostcodeValidation(eventToAdd);
		validator.eventCapacityValidation(eventToAdd);
		validator.eventDateValidation(eventToAdd);
		eventToAdd.setCustomer(this.customerRepo.findById(custid)
				.orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist")));
		this.customer = this.customerRepo.findById(custid);
		this.email = this.customer.getCustomerEmail();
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
