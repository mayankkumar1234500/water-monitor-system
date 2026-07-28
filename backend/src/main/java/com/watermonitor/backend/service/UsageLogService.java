package com.watermonitor.backend.service;

import com.watermonitor.backend.dto.UsageLogRequest;
import com.watermonitor.backend.entity.Alert;
import com.watermonitor.backend.entity.Household;
import com.watermonitor.backend.entity.WaterUsageLog;
import com.watermonitor.backend.repository.AlertRepository;
import com.watermonitor.backend.repository.HouseholdRepository;
import com.watermonitor.backend.repository.WaterUsageLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsageLogService {

    private final WaterUsageLogRepository usageLogRepository;
    private final HouseholdRepository householdRepository;
    private final AlertRepository alertRepository;

    private static final double HIGH_USAGE_THRESHOLD_LITERS = 500.0;

    public UsageLogService(WaterUsageLogRepository usageLogRepository,
                           HouseholdRepository householdRepository,
                           AlertRepository alertRepository) {
        this.usageLogRepository = usageLogRepository;
        this.householdRepository = householdRepository;
        this.alertRepository = alertRepository;
    }

    public WaterUsageLog logUsage(UsageLogRequest request) {
        Household household = householdRepository.findById(request.getHouseholdId())
                .orElseThrow(() -> new RuntimeException("Household not found"));

        WaterUsageLog log = new WaterUsageLog();
        log.setHousehold(household);
        log.setDate(request.getDate());
        log.setLitersUsed(request.getLitersUsed());
        WaterUsageLog saved = usageLogRepository.save(log);

        if (request.getLitersUsed() > HIGH_USAGE_THRESHOLD_LITERS) {
            Alert alert = new Alert();
            alert.setHousehold(household);
            alert.setDate(request.getDate());
            alert.setMessage("High water usage detected: " + request.getLitersUsed() + " L on " + request.getDate());
            alert.setResolved(false);
            alertRepository.save(alert);
        }

        return saved;
    }

    public List<WaterUsageLog> getUsageByHousehold(Long householdId) {
        return usageLogRepository.findByHouseholdId(householdId);
    }
}