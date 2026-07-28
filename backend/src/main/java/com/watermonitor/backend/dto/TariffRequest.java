package com.watermonitor.backend.dto;

import lombok.Data;

@Data
public class TariffRequest {
    private Long apartmentId;
    private Double baseRatePerKL;
    private Double higherRatePerKL;
    private Double thresholdKL;
}