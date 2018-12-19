package com.dms.lab7.repository;

import com.dms.lab7.entity.PossibleState;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PossibleStateRep extends JpaRepository<PossibleState, Long> {
    @Query(value = "SELECT * from POSSIBLE_STATE where TYPE_PROCESS_ID = ?", nativeQuery = true)
    List<PossibleState> findAllByProcess(long idProc);
}
