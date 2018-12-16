package com.dms.lab7.repository;

import com.dms.lab7.entity.TypeDecision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeDecisionRep extends JpaRepository<TypeDecision, Long> {
    @Query(value = "select * from dual", nativeQuery = true)
    List<TypeDecision> findAllByStateId(Long id);
}
