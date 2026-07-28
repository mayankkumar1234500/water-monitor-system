package com.watermonitor.backend.controller;

import com.watermonitor.backend.dto.HouseholdRequest;
import com.watermonitor.backend.entity.Household;
import com.watermonitor.backend.service.HouseholdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public Household addHousehold(@RequestBody HouseholdRequest request) {
        return householdService.addHousehold(request);
    }

    @GetMapping("/apartment/{apartmentId}")
    public List<Household> getHouseholdsByApartment(@PathVariable Long apartmentId) {
        return householdService.getHouseholdsByApartment(apartmentId);
    }

    @GetMapping("/resident/{email}")
    public Household getHouseholdByResident(@PathVariable String email) {
        return householdService.getHouseholdByResidentEmail(email);
    }
}