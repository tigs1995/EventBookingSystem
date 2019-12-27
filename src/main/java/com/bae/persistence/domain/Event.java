package com.bae.persistence.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventId")
	private Long eventId;

	@Column(name = "eventPostcode")
	private String eventPostcode;

	@Column(name = "eventCapacity")
	private int eventCapacity;

	@Column(name = "eventDate")
	private LocalDate eventDate;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Event(String eventPostcode, int eventCapacity, LocalDate eventDate, Customer customer) {
		super();
		this.eventPostcode = eventPostcode;
		this.eventCapacity = eventCapacity;
		this.eventDate = eventDate;
		this.customer = customer;
	}
	
	
	public Event() {

	}
	
	//for Event Service test purposes 
	public Event(String eventPostcode, int eventCapacity, LocalDate eventDate) {
		this.eventPostcode = eventPostcode;
		this.eventCapacity = eventCapacity;
		this.eventDate = eventDate;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventPostcode() {
		return eventPostcode;
	}

	public void setEventPostcode(String eventPostcode) {
		this.eventPostcode = eventPostcode;
	}

	public int getEventCapacity() {
		return eventCapacity;
	}

	public void setEventCapacity(int eventCapacity) {
		this.eventCapacity = eventCapacity;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + eventCapacity;
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((eventPostcode == null) ? 0 : eventPostcode.hashCode());
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
		Event other = (Event) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (eventCapacity != other.eventCapacity)
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventPostcode == null) {
			if (other.eventPostcode != null)
				return false;
		} else if (!eventPostcode.equals(other.eventPostcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "eventId=" + eventId + ", eventPostcode=" + eventPostcode + ", eventCapacity=" + eventCapacity
				+ ", eventDate=" + eventDate;
	}
	
	

}
