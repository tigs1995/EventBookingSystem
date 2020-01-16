package com.bae.service;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.bae.persistence.repository.CustomerRepository;
import com.bae.persistence.repository.EventRepository;
import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;

@Service
public class EventService {

	private EventRepository eventRepo;

	private CustomerRepository customerRepo;
			
	private String firstNameCaps;
		
	private String lastNameCaps;
		
	private String phone;
	
	private Long custNumber;
	
	private String postcode;
	
	private int capacity;
	
	private String date;
		
	private ValidationService validator;

	public EventService(EventRepository eventRepo, CustomerRepository customerRepo, ValidationService validator) {
		this.eventRepo = eventRepo;
		this.customerRepo = customerRepo;
		this.validator = validator;
	}

	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}
	
	public void sendEmail(String email) {
		final String username = "toastclubltd@gmail.com";
        final String pw = "magojmftzpoaumkg";
        final Logger logger = Logger.getAnonymousLogger();

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, pw);
            }
          });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("toastclubltd@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Confirmation of event enquiry - Customer Number: " + this.custNumber);
            message.setText("Dear " + this.firstNameCaps + " " + this.lastNameCaps + ",\n \n Thank you for your enquiry. Please see your details below:\n "
    				+ "Customer Phone Number: " + this.phone + "\n Event Postcode: " + this.postcode 
    				+ "\n Event Capacity: " + this.capacity + "\nEvent Date: " + this.date + ". \n \n Please let us know if any of this is incorrect."
    				+ "We will be in touch with a quote. \n Please use your customer number when booking future events (" + this.custNumber + ")."
    				+ "\n \n Kind Regards, \n The Toast Club Ltd");

            Transport.send(message);

        } catch (MessagingException e) {
        	logger.log(Level.WARNING, "Email not sent@");
        }
	}

	public Event addNewEvent(Event eventToAdd, Long custid) {
		Customer customer;
		String firstName;
		String lastName;
		String email;
		validator.eventPostcodeValidation(eventToAdd);
		validator.eventCapacityValidation(eventToAdd);
		validator.eventDateValidation(eventToAdd);
		eventToAdd.setCustomer(this.customerRepo.findById(custid)
				.orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist")));
		customer = this.customerRepo.findById(custid).orElseThrow(() -> new EntityNotFoundException("Customer Does Not Exist"));
		firstName = customer.getFirstName().toLowerCase();
		this.firstNameCaps = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
		lastName = customer.getLastName().toLowerCase();
		this.lastNameCaps = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
		email = customer.getEmail();
		this.phone = customer.getPhone();
		this.custNumber = custid;
		this.postcode = eventToAdd.getEventPostcode();
		this.capacity = eventToAdd.getEventCapacity();
		this.date = eventToAdd.getEventDate().toString();
		sendEmail(email);
		
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
