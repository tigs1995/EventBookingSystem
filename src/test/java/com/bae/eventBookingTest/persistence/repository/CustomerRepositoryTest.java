package com.bae.eventBookingTest.persistence.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repository.CustomerRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired    
	private CustomerRepository repo;
	
	private Customer testCustomer = new Customer("Mary", "Higgins", "mary.hig@hotmail.com", "07394859607");
		
	@Before
	public void init() {
		this.repo.deleteAll();
		this.repo.save(this.testCustomer);
	}

	@Test
	public void testCustRepoFindAll() {
		assertEquals(this.repo.findAll().get(0), testCustomer);
	}
}
