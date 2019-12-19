package com.bae.service;

import java.time.LocalDate;
import java.util.regex.Pattern;

import javax.validation.ValidationException;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;

public class ValidationService {
	
	public void eventPostcodeValidation(Event eventToAdd){
		String regexForValidation = "^[A-Za-z]{1,2}[0-9Rr][0-9A-Za-z]? [0-9][AaBbD-Hd-hJjLlNnP-Up-uW-Zw-z]{2}$";
		Pattern pattern = Pattern.compile(regexForValidation);
		if (pattern.matcher(eventToAdd.getEventPostcode()).matches() != true) {
			throw new ValidationException("Wrong postcode format.");
		}
		
	}
	
	public void eventCapacityValidation(Event eventToAdd){
		if (eventToAdd.getEventCapacity() > 5000) {
			throw new ValidationException("Capacity exceeds limit (5,000).");
		}
		else if (eventToAdd.getEventCapacity() <= 0) {
			throw new ValidationException("Capacity too low (minimum 1).");
		}
		
	}
	
	public void eventDateValidation(Event eventToAdd){
		LocalDate eventDate = eventToAdd.getEventDate();
		if (eventDate.isBefore(LocalDate.now()))
		{
			throw new ValidationException("Date is in the past.");
		}
		else if (eventDate.isAfter(LocalDate.now().plusYears(5))) 
		{
			throw new ValidationException("Date is too far in the future.");
		}
		
	}
	
	public void customerEmailValidation(Customer custToAdd){
		String regexForValidation = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern pattern = Pattern.compile(regexForValidation);
		if (pattern.matcher(custToAdd.getCustomerEmail()).matches() != true) {
			throw new ValidationException("Invalid email.");  
		}
		
	}
	
	public void customerNumberValidation(Customer custToAdd){
		String regexForValidation = "";
		Pattern pattern = Pattern.compile(regexForValidation);
		if (pattern.matcher(custToAdd.getCustomerNumber()).matches() != true) {
			throw new ValidationException("Invalid phone number.");  
		}
		
	}
	

}
