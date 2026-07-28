package com.watermonitor.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tariff_plans")
@Data
public class TariffPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    private Double baseRatePerKL;

    private Double higherRatePerKL;

    private Double thresholdKL;
}