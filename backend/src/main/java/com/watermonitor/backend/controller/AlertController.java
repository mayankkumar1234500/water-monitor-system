package com.watermonitor.backend.controller;

import com.watermonitor.backend.entity.Alert;
import com.watermonitor.backend.repository.AlertRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertRepository alertRepository;

    public AlertController(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @GetMapping("/household/{householdId}")
    public List<Alert> getAlerts(@PathVariable Long householdId) {
        return alertRepository.findByHouseholdId(householdId);
    }
}