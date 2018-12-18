package com.dms.lab7.repository;

import com.dms.lab7.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRep extends JpaRepository<State, Long> {
    @Query(value = "select * from DECISION", nativeQuery = true)
    State findCurrentStateByProcessId(Long idProc);
}
