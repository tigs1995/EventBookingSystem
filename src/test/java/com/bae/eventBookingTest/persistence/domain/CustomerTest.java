package com.bae.eventBookingTest.persistence.domain;

import static org.junit.Assert.*;

import org.junit.Assert;
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
		assertEquals("Tigs", this.testCustomer.getFirstName());
	}

	@Test
	public void testSetGetLastName() {
		testCustomer.setLastName("Knowles");
		assertEquals("Knowles", this.testCustomer.getLastName());
	}

	@Test
	public void testSetGetEmail() {
		testCustomer.setEmail("tigs@hotmail.com");
		assertEquals("tigs@hotmail.com", this.testCustomer.getEmail());
	}

	@Test
	public void testSetGetNumber() {
		testCustomer.setPhone("07493849586");
		assertEquals("07493849586", this.testCustomer.getPhone());	}
	
	@Test public void equalsFalseTest2() {
	    Customer customer1 = new Customer("Tigs", "Knowles", "tigs@msn.com", "07384958675");
	    Customer customer2 = new Customer("George", "Knowles", "tigs@msn.com", "07857463748");
	    Assert.assertNotEquals(customer1, customer2);
	}

	@Test public void equalsTrueTest() {
		Customer customer1 = new Customer("Tigs", "Knowles", "tigs@msn.com", "07384958675");
	    Customer customer2 = new Customer("Tigs", "Knowles", "tigs@msn.com", "07384958675");
	    Assert.assertEquals(customer1, customer2);
	}
	
	@Test
	public void testHashcode() {
		Customer x = new Customer("Tigs", "Knowles", "tigs@msn.com", "07384958675");  
		Customer y = new Customer("Tigs", "Knowles", "tigs@msn.com", "07384958675");
	    Assert.assertTrue(x.equals(y) && y.equals(x));
	    Assert.assertTrue(x.hashCode() == y.hashCode());
	}

}
