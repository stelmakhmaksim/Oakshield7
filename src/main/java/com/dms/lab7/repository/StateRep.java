package com.dms.lab7.repository;

import com.dms.lab7.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRep extends JpaRepository<State, Long> {
}
