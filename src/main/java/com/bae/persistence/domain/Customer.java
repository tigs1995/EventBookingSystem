package com.bae.persistence.domain;

import java.util.Set;

<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> mergefix
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;

=======
>>>>>>> mergefix
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String firstName;
	private String lastName;
<<<<<<< HEAD
	private String email;
	private String phone;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Set<Event> events;

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Customer() {

	}

	public Customer(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
=======
	private String customerEmail;
	private String customerNumber;

	@OneToMany(mappedBy = "customer")
	private Set<Event> events;

	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String customerEmail, String customerNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerEmail = customerEmail;
		this.customerNumber = customerNumber;
>>>>>>> mergefix
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

<<<<<<< HEAD
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

=======
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}


>>>>>>> mergefix
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
<<<<<<< HEAD
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
=======
		result = prime * result + ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
>>>>>>> mergefix
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
<<<<<<< HEAD
		if (email == null) {
			if (other.email != null)
				return false;
		} 
		else if (!email.equals(other.email))
=======
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
>>>>>>> mergefix
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
<<<<<<< HEAD
		} 
		else if (!customerId.equals(other.customerId))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} 
		else if (!phone.equals(other.phone))
=======
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerNumber == null) {
			if (other.customerNumber != null)
				return false;
		} else if (!customerNumber.equals(other.customerNumber))
>>>>>>> mergefix
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
<<<<<<< HEAD
		} 
		else if (!events.equals(other.events))
=======
		} else if (!events.equals(other.events))
>>>>>>> mergefix
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
<<<<<<< HEAD
		} 
		else if (!firstName.equals(other.firstName))
=======
		} else if (!firstName.equals(other.firstName))
>>>>>>> mergefix
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
<<<<<<< HEAD
		} 
		else if (!lastName.equals(other.lastName))
=======
		} else if (!lastName.equals(other.lastName))
>>>>>>> mergefix
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
<<<<<<< HEAD
				+ ", customerEmail=" + email + ", customerPhone" + phone + "]";
	}
=======
				+ ", customerEmail=" + customerEmail + ", customerNumber=" + customerNumber	+ "]";
	}
	
	
>>>>>>> mergefix

}
