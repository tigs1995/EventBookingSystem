package com.bae.eventBookingTest.persistence.repository;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Event;
import com.bae.persistence.repository.EventRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

	@Autowired
	private EventRepository repo;

	private Event testEvent = new Event();

	@Before
	public void init() {
		this.repo.deleteAll();
		this.repo.save(this.testEvent);
	}

	@Test
	public void testEventRepoFindAll() {
		testEvent.setEventDate(LocalDate.of(2019, 12, 02));
		testEvent.setEventCapacity(250);
		testEvent.setEventPostcode("HP265UQ");
		assertEquals(this.repo.findAll().get(0), testEvent);
	}

}
