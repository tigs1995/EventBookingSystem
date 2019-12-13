package com.bae.eventBookingTest.persistence.domain;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bae.persistence.domain.Event;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventTest {

	private Event testEvent = new Event();

	@Test
	public void testSetGetPostcode() {
		testEvent.setEventPostcode("HP279NQ");
		assertEquals(this.testEvent.getEventPostcode(), "HP279NQ");
	}

	@Test
	public void testSetGetCapacity() {
		testEvent.setEventCapacity(250);
		assertEquals(this.testEvent.getEventCapacity(), 250);
	}

	@Test
	public void testSetGetDate() {
		String date = "12-02-2019";
		Date d = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		testEvent.setEventDate(d);
		assertEquals(sdf.format(this.testEvent.getEventDate()).toString(), "12-02-2019");
	}

}
