package com.watermonitor.backend.service;

import com.watermonitor.backend.dto.TariffRequest;
import com.watermonitor.backend.entity.Apartment;
import com.watermonitor.backend.entity.TariffPlan;
import com.watermonitor.backend.repository.ApartmentRepository;
import com.watermonitor.backend.repository.TariffPlanRepository;
import org.springframework.stereotype.Service;

@Service
public class TariffService {

    private final TariffPlanRepository tariffPlanRepository;
    private final ApartmentRepository apartmentRepository;

    public TariffService(TariffPlanRepository tariffPlanRepository, ApartmentRepository apartmentRepository) {
        this.tariffPlanRepository = tariffPlanRepository;
        this.apartmentRepository = apartmentRepository;
    }

    public TariffPlan setTariff(TariffRequest request) {
        Apartment apartment = apartmentRepository.findById(request.getApartmentId())
                .orElseThrow(() -> new RuntimeException("Apartment not found"));

        TariffPlan tariff = tariffPlanRepository.findByApartmentId(request.getApartmentId())
                .orElse(new TariffPlan());

        tariff.setApartment(apartment);
        tariff.setBaseRatePerKL(request.getBaseRatePerKL());
        tariff.setHigherRatePerKL(request.getHigherRatePerKL());
        tariff.setThresholdKL(request.getThresholdKL());

        return tariffPlanRepository.save(tariff);
    }
}