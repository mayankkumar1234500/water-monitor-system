package com.watermonitor.backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MeterReadingDto {
    private Long householdId;
    private LocalDate readingDate;
    private Double readingValue;
}