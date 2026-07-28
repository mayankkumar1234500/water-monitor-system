package com.watermonitor.backend.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsageLogRequest {
    private Long householdId;
    private LocalDate date;
    private Double litersUsed;
}