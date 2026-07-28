package com.watermonitor.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "apartments")
@Data
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToOne
    @JoinColumn(name = "community_admin_id")
    private User communityAdmin;
}