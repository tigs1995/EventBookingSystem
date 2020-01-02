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
	
	public void customerPhoneValidation(Customer custToAdd){
		String regexForValidation = "((?:\\+|00)[17](?: |\\-)?|(?:\\+|00)[1-9]\\d{0,2}(?: |\\-)?|(?:\\+|00)1\\-\\d{3}(?: |\\-)?)?(0\\d|\\([0-9]{3}\\)|[1-9]{0,3})(?:((?: |\\-)[0-9]{2}){4}|((?:[0-9]{2}){4})|((?: |\\-)[0-9]{3}(?: |\\-)[0-9]{4})|([0-9]{7}))";
		Pattern pattern = Pattern.compile(regexForValidation);
		if (pattern.matcher(custToAdd.getCustomerNumber()).matches() != true) {
			throw new ValidationException("Invalid phone number.");  
		}
		
	}
	
	public void customerFirstNameValidation(Customer custToAdd){
		int nameLength = custToAdd.getFirstName().length();
		if (nameLength > 60 || nameLength <= 0) {
			throw new ValidationException("First name must be between 1 and 60 characters inclusive.");  
		}
		
	}
	
	public void customerLastNameValidation(Customer custToAdd){
		int nameLength = custToAdd.getLastName().length();
		if (nameLength > 80 || nameLength <= 0) {
			throw new ValidationException("First name must be between 1 and 80 characters inclusive.");  
		}
		
	}
	

}