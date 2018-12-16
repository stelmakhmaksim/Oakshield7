package com.dms.lab7.repository;

import com.dms.lab7.entity.Prod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRep extends JpaRepository<Prod, Long> {
}
