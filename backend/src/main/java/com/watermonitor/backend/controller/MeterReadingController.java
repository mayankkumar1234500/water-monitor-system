package com.watermonitor.backend.controller;

import com.watermonitor.backend.dto.MeterReadingDto;
import com.watermonitor.backend.entity.Household;
import com.watermonitor.backend.entity.MeterReading;
import com.watermonitor.backend.repository.HouseholdRepository;
import com.watermonitor.backend.repository.MeterReadingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/meter-readings")
public class MeterReadingController {

    private final MeterReadingRepository meterReadingRepository;
    private final HouseholdRepository householdRepository;

    public MeterReadingController(MeterReadingRepository meterReadingRepository, HouseholdRepository householdRepository) {
        this.meterReadingRepository = meterReadingRepository;
        this.householdRepository = householdRepository;
    }

    @PostMapping
    public MeterReading saveReading(@RequestBody MeterReadingDto dto) {
        Household household = householdRepository.findById(dto.getHouseholdId())
                .orElseThrow(() -> new RuntimeException("Household not found"));

        MeterReading reading = new MeterReading();
        reading.setHousehold(household);
        reading.setReadingDate(dto.getReadingDate());
        reading.setReadingValue(dto.getReadingValue());

        return meterReadingRepository.save(reading);
    }

    @GetMapping("/household/{householdId}")
    public List<MeterReading> getReadings(@PathVariable Long householdId) {
        return meterReadingRepository.findByHouseholdIdOrderByReadingDateDesc(householdId);
    }
}