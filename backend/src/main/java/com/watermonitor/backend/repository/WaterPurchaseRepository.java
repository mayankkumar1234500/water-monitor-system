package com.watermonitor.backend.repository;

import com.watermonitor.backend.entity.WaterPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaterPurchaseRepository extends JpaRepository<WaterPurchase, Long> {
    List<WaterPurchase> findByApartmentId(Long apartmentId);
}