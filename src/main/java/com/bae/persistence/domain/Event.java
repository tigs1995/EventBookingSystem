package com.bae.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	private String eventPostCode;
	private String eventCapacity;
	private Long customerId;
	
	public Event() {
	}
	
	public Event(String eventPostCode, String eventCapacity) {
		super();
		this.eventPostCode = eventPostCode;
		this.eventCapacity = eventCapacity;
	}
	
	
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventPostCode() {
		return eventPostCode;
	}
	public void setEventPostCode(String eventPostCode) {
		this.eventPostCode = eventPostCode;
	}
	public String getEventCapacity() {
		return eventCapacity;
	}
	public void setEventCapacity(String eventCapacity) {
		this.eventCapacity = eventCapacity;
	}
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventPostCode=" + eventPostCode + ", eventCapacity=" + eventCapacity
				+ ", customerId=" + customerId + "]";
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
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (eventCapacity == null) {
			if (other.eventCapacity != null)
				return false;
		} else if (!eventCapacity.equals(other.eventCapacity))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventPostCode == null) {
			if (other.eventPostCode != null)
				return false;
		} else if (!eventPostCode.equals(other.eventPostCode))
			return false;
		return true;
	}


	

	
	
	
	
	
	
	
	
	


}
