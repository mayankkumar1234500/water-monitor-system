package com.watermonitor.backend.controller;

import com.watermonitor.backend.entity.Bill;
import com.watermonitor.backend.repository.BillRepository;
import com.watermonitor.backend.service.BillingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillingService billingService;
    private final BillRepository billRepository;

    public BillController(BillingService billingService, BillRepository billRepository) {
        this.billingService = billingService;
        this.billRepository = billRepository;
    }

    @PostMapping("/generate/{householdId}")
    public Bill generateBill(@PathVariable Long householdId) {
        return billingService.generateBill(householdId);
    }

    @GetMapping("/household/{householdId}")
    public List<Bill> getBills(@PathVariable Long householdId) {
        return billingService.getBillsByHousehold(householdId);
    }

    @PutMapping("/{billId}/pay")
    public Bill payBill(@PathVariable Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        bill.setStatus("PAID");
        return billRepository.save(bill);
    }
}