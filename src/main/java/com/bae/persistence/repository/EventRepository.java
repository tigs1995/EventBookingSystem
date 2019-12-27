package com.bae.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
