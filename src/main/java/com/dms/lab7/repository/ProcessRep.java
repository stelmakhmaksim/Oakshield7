package com.dms.lab7.repository;

import com.dms.lab7.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRep extends JpaRepository<Process, Long> {
}
