package com.dms.lab7.repository;

import com.dms.lab7.entity.Trajectory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrajectoryRep extends JpaRepository<Trajectory, Long> {
    @Query(value = "select * from TRAJECTORY where STATE_ID = ?", nativeQuery = true)
    List<Trajectory> findByStateId(Long stateId);
}
