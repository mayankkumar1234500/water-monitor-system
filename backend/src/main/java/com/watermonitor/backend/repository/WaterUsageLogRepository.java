package com.watermonitor.backend.repository;

import com.watermonitor.backend.entity.WaterUsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaterUsageLogRepository extends JpaRepository<WaterUsageLog, Long> {
    List<WaterUsageLog> findByHouseholdId(Long householdId);
}