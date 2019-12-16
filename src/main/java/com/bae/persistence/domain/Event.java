package com.bae.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date eventDate;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Event(String eventPostcode, int eventCapacity, Date eventDate, Customer customer) {
		super();
		this.eventPostcode = eventPostcode;
		this.eventCapacity = eventCapacity;
		this.eventDate = eventDate;
		this.customer = customer;
	}
	
	
	public Event() {

	}
	
	//for Event Service test purposes 
	public Event(String eventPostcode, int eventCapacity, Date eventDate) {
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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
		return "Event [eventId=" + eventId + ", eventPostcode=" + eventPostcode + ", eventCapacity=" + eventCapacity
				+ ", eventDate=" + eventDate + "]";
	}

}
