package com.bae.service;

import java.time.LocalDate;
import java.util.List;
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
	
	private Customer customer;
	
	private String firstName;
	
	private String firstNameCaps;
	
	private String lastName;
	
	private String lastNameCaps;
	
	private String email;
	
	private String phone;
	
	private Long custNumber;
	
	private String postcode;
	
	private int capacity;
	
	private String date;
		
	private ValidationService validator = new ValidationService();

//	@Autowired
//	private JavaMailSender javaMailSender;

	public EventService(EventRepository eventRepo, CustomerRepository customerRepo) {
		this.eventRepo = eventRepo;
		this.customerRepo = customerRepo;
	}

	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

//	public void sendEmail(String email) {
//
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setFrom("toastclubltd@gmail.com");
//
//		msg.setSubject("Confirmation of event enquiry - Customer Number: " + this.custNumber);
//		msg.setText("Dear " + this.firstNameCaps + " " + this.lastNameCaps + ",\n \n Thank you for your enquiry. Please see your details below:\n "
//				+ "Customer Phone Number: " + this.phone + "\n Event Postcode: " + this.postcode 
//				+ "\n Event Capacity: " + this.capacity + "\nEvent Date: " + this.date + ". \n \n Please let us know if any of this is incorrect."
//				+ "We will be in touch with a quote. \n Please use your customer number when booking future events (" + this.custNumber + ")."
//				+ "\n \n Kind Regards, \n The Toast Club Ltd");
//		javaMailSender.send(msg);
//
//	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		validator.eventPostcodeValidation(eventToAdd);
		validator.eventCapacityValidation(eventToAdd);
		validator.eventDateValidation(eventToAdd);
		eventToAdd.setCustomer(this.customerRepo.findById(custid)
				.orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist")));
		this.customer = this.customerRepo.findById(custid).orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist"));
		this.firstName = this.customer.getFirstName().toLowerCase();
		this.firstNameCaps = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
		this.lastName = this.customer.getLastName().toLowerCase();
		this.lastNameCaps = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
		this.email = this.customer.getEmail();
		this.phone = this.customer.getPhone();
		this.custNumber = custid;
		this.postcode = eventToAdd.getEventPostcode();
		this.capacity = eventToAdd.getEventCapacity();
		this.date = eventToAdd.getEventDate().toString();
//		sendEmail(this.email);
		
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

	public boolean checkExisting(Long eventid) {
		return this.eventRepo.existsById(eventid);
	}
}
