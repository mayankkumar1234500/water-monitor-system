package com.watermonitor.backend.dto;

import lombok.Data;

@Data
public class HouseholdRequest {
    private String flatNumber;
    private Long apartmentId;
    private Long residentId;
}