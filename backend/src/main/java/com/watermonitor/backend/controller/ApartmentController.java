package com.watermonitor.backend.controller;

import com.watermonitor.backend.dto.ApartmentRequest;
import com.watermonitor.backend.entity.Apartment;
import com.watermonitor.backend.service.ApartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping
    public Apartment createApartment(@RequestBody ApartmentRequest request) {
        return apartmentService.createApartment(request);
    }

    @GetMapping
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }
}