package com.bae.eventBookingTest.persistence.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bae.persistence.domain.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerTest {

	private Customer testCustomer = new Customer();

	@Test
	public void testSetGetFirstName() {
		testCustomer.setFirstName("Tigs");
		assertEquals(this.testCustomer.getFirstName(), "Tigs");
	}

	@Test
	public void testSetGetLastName() {
		testCustomer.setLastName("Knowles");
		assertEquals(this.testCustomer.getLastName(), "Knowles");
	}

	@Test
	public void testSetGetEmail() {
		testCustomer.setCustomerEmail("tigsye@hotmail.com");
		assertEquals(this.testCustomer.getCustomerEmail(), "tigsye@hotmail.com");
	}

	@Test
	public void testSetGetNumber() {
		testCustomer.setCustomerNumber("07493849586");
		assertEquals(this.testCustomer.getCustomerNumber(), "07493849586");
	}

}
