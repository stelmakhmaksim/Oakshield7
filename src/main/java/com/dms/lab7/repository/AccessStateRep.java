package com.dms.lab7.repository;

import com.dms.lab7.entity.AccessState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessStateRep extends JpaRepository<AccessState, Long> {
}
