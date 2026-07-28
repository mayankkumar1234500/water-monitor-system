package com.watermonitor.backend.dto;

import lombok.Data;

@Data
public class ApartmentRequest {
    private String name;
    private String address;
    private Long communityAdminId;
}