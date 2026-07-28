package com.watermonitor.backend.repository;

import com.watermonitor.backend.entity.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TariffPlanRepository extends JpaRepository<TariffPlan, Long> {
    Optional<TariffPlan> findByApartmentId(Long apartmentId);
}