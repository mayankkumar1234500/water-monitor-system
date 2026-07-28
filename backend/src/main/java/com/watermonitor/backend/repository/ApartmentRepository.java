package com.watermonitor.backend.repository;

import com.watermonitor.backend.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}