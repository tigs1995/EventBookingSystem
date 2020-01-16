package com.bae.eventBookingTest.persistence.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventTest {

	private Event testEvent = new Event();

	@Test
	public void testSetGetPostcode() {
		testEvent.setEventPostcode("HP456WZ");
		assertEquals("HP456WZ", this.testEvent.getEventPostcode());
	}

	@Test
	public void testSetGetCapacity() {
		testEvent.setEventCapacity(250);
		assertEquals(250, this.testEvent.getEventCapacity());
	}

	@Test
	public void testSetGetDate() {
		testEvent.setEventDate(LocalDate.of(2019, 12, 02));
		assertEquals(LocalDate.of(2019,  12,  02), this.testEvent.getEventDate());
	}
	
	@Test public void equalsFalseTest2() {
	    Event event1 = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02));
	    Event event2 = new Event("HP895GE", 250, LocalDate.of(2019, 12, 02));
	    Assert.assertNotEquals(event1, event2);
	}

	@Test public void equalsTrueTest() {
		Event event1 = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02));
	    Event event2 = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02));
	    Assert.assertEquals(event1, event2);
	}
	
	@Test
	public void testHashcode() {
	    Event x = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02));  
	    Event y = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02));
	    Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}
	
	@Test
	public void constructorTest() {
		Customer customer = new Customer("Tigs", "Knowles", "tigs@hotmail.com", "07393849583");
		Event event = new Event("HP829HE", 250, LocalDate.of(2019, 12, 02), customer);
		Assert.assertEquals("HP829HE", event.getEventPostcode());
	}
}
