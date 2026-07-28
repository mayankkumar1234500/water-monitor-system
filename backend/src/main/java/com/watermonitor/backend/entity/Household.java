package com.watermonitor.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "households")
@Data
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flatNumber;

    @ManyToOne
    @JoinColumn(name = "apartment_id", nullable = false)
    private Apartment apartment;

    @OneToOne
    @JoinColumn(name = "resident_id")
    private User resident;
}