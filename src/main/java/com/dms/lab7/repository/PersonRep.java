package com.dms.lab7.repository;

import com.dms.lab7.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRep extends JpaRepository<Person, Long> {
}
