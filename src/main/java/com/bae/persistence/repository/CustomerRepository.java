package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bae.persistence.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
	boolean existsById(Long custid);
	
}
