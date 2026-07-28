package com.watermonitor.backend.service;

import com.watermonitor.backend.dto.ApartmentRequest;
import com.watermonitor.backend.entity.Apartment;
import com.watermonitor.backend.entity.User;
import com.watermonitor.backend.repository.ApartmentRepository;
import com.watermonitor.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final UserRepository userRepository;

    public ApartmentService(ApartmentRepository apartmentRepository, UserRepository userRepository) {
        this.apartmentRepository = apartmentRepository;
        this.userRepository = userRepository;
    }

    public Apartment createApartment(ApartmentRequest request) {
        Apartment apartment = new Apartment();
        apartment.setName(request.getName());
        apartment.setAddress(request.getAddress());

        if (request.getCommunityAdminId() != null) {
            User admin = userRepository.findById(request.getCommunityAdminId())
                    .orElseThrow(() -> new RuntimeException("Community Admin not found"));
            apartment.setCommunityAdmin(admin);
        }

        return apartmentRepository.save(apartment);
    }

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }
}