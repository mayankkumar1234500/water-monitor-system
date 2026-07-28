package com.watermonitor.backend.service;

import com.watermonitor.backend.dto.HouseholdRequest;
import com.watermonitor.backend.entity.Apartment;
import com.watermonitor.backend.entity.Household;
import com.watermonitor.backend.entity.User;
import com.watermonitor.backend.repository.ApartmentRepository;
import com.watermonitor.backend.repository.HouseholdRepository;
import com.watermonitor.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    private final ApartmentRepository apartmentRepository;
    private final UserRepository userRepository;

    public HouseholdService(HouseholdRepository householdRepository,
                            ApartmentRepository apartmentRepository,
                            UserRepository userRepository) {
        this.householdRepository = householdRepository;
        this.apartmentRepository = apartmentRepository;
        this.userRepository = userRepository;
    }

    public Household addHousehold(HouseholdRequest request) {
        Apartment apartment = apartmentRepository.findById(request.getApartmentId())
                .orElseThrow(() -> new RuntimeException("Apartment not found"));

        Household household = new Household();
        household.setFlatNumber(request.getFlatNumber());
        household.setApartment(apartment);

        if (request.getResidentId() != null) {
            User resident = userRepository.findById(request.getResidentId())
                    .orElseThrow(() -> new RuntimeException("Resident not found"));
            household.setResident(resident);
        }

        return householdRepository.save(household);
    }

    public List<Household> getHouseholdsByApartment(Long apartmentId) {
        return householdRepository.findByApartmentId(apartmentId);
    }

    public Household getHouseholdByResidentEmail(String email) {
        return householdRepository.findByResidentEmail(email).orElse(null);
    }
}