package com.watermonitor.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "water_purchases")
@Data
public class WaterPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long apartmentId;
    private String billingCycleName;
    private LocalDate purchaseDate;
    private String source; // e.g. "Water Tanker Delivery"
    private Double volumeLiters;
    private Double unitCostPerLiter;
    private Double totalCost;
    private String notes;
}