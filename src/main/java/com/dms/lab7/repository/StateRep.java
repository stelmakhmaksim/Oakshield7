package com.dms.lab7.repository;

import com.dms.lab7.entity.State;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StateRep extends JpaRepository<State, Long> {
    @Query(value = "select * from STATE where TYPE_PROCESS_ID = ?", nativeQuery = true)
    List<State> findStatesByProcessId(Long idProc);

    @Query(value = "select * from STATE where TYPE_PROCESS_ID = ? and TYPE_STATE_ID = ?", nativeQuery = true)
    State findStatesByProcessIdAndTypeStateId(Long idProc, Long id);
}
