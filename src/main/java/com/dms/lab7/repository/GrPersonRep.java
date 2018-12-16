package com.dms.lab7.repository;

import com.dms.lab7.entity.GrPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrPersonRep extends JpaRepository<GrPerson, Long> {
}
