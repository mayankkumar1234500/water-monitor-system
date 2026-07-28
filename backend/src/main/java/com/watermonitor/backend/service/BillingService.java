package com.watermonitor.backend.service;

import com.watermonitor.backend.entity.Bill;
import com.watermonitor.backend.entity.Household;
import com.watermonitor.backend.entity.TariffPlan;
import com.watermonitor.backend.entity.WaterUsageLog;
import com.watermonitor.backend.repository.BillRepository;
import com.watermonitor.backend.repository.HouseholdRepository;
import com.watermonitor.backend.repository.TariffPlanRepository;
import com.watermonitor.backend.repository.WaterUsageLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillingService {

    private final HouseholdRepository householdRepository;
    private final WaterUsageLogRepository usageLogRepository;
    private final TariffPlanRepository tariffPlanRepository;
    private final BillRepository billRepository;

    public BillingService(HouseholdRepository householdRepository,
                          WaterUsageLogRepository usageLogRepository,
                          TariffPlanRepository tariffPlanRepository,
                          BillRepository billRepository) {
        this.householdRepository = householdRepository;
        this.usageLogRepository = usageLogRepository;
        this.tariffPlanRepository = tariffPlanRepository;
        this.billRepository = billRepository;
    }

    public Bill generateBill(Long householdId) {
        Household household = householdRepository.findById(householdId)
                .orElseThrow(() -> new RuntimeException("Household not found"));

        Long apartmentId = household.getApartment().getId();

        TariffPlan tariff = tariffPlanRepository.findByApartmentId(apartmentId)
                .orElseThrow(() -> new RuntimeException("Tariff plan not set for this apartment"));

        List<WaterUsageLog> usageLogs = usageLogRepository.findByHouseholdId(householdId);

        double totalLiters = usageLogs.stream()
                .mapToDouble(WaterUsageLog::getLitersUsed)
                .sum();

        double totalKL = totalLiters / 1000.0;

        double amount;
        if (totalKL <= tariff.getThresholdKL()) {
            amount = totalKL * tariff.getBaseRatePerKL();
        } else {
            double baseAmount = tariff.getThresholdKL() * tariff.getBaseRatePerKL();
            double extraKL = totalKL - tariff.getThresholdKL();
            double extraAmount = extraKL * tariff.getHigherRatePerKL();
            amount = baseAmount + extraAmount;
        }

        Bill bill = new Bill();
        bill.setHousehold(household);
        bill.setBillMonth(LocalDate.now());
        bill.setTotalLitersUsed(totalLiters);
        bill.setTotalAmount(amount);
        bill.setStatus("PENDING");

        return billRepository.save(bill);
    }

    public List<Bill> getBillsByHousehold(Long householdId) {
        return billRepository.findByHouseholdId(householdId);
    }
}