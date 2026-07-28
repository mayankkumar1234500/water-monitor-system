package com.watermonitor.backend.dto;

import com.watermonitor.backend.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}