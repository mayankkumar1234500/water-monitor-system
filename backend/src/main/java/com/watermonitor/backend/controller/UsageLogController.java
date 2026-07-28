package com.watermonitor.backend.controller;

import com.watermonitor.backend.dto.UsageLogRequest;
import com.watermonitor.backend.entity.WaterUsageLog;
import com.watermonitor.backend.service.UsageLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class UsageLogController {

    private final UsageLogService usageLogService;

    public UsageLogController(UsageLogService usageLogService) {
        this.usageLogService = usageLogService;
    }

    @PostMapping
    public WaterUsageLog logUsage(@RequestBody UsageLogRequest request) {
        return usageLogService.logUsage(request);
    }

    @GetMapping("/household/{householdId}")
    public List<WaterUsageLog> getUsage(@PathVariable Long householdId) {
        return usageLogService.getUsageByHousehold(householdId);
    }
}