package com.watermonitor.backend.repository;

import com.watermonitor.backend.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByHouseholdId(Long householdId);
}