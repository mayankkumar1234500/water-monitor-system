package com.watermonitor.backend.controller;

import com.watermonitor.backend.entity.WaterPurchase;
import com.watermonitor.backend.repository.WaterPurchaseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/water-purchases")
public class WaterPurchaseController {

    private final WaterPurchaseRepository repository;

    public WaterPurchaseController(WaterPurchaseRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public WaterPurchase logPurchase(@RequestBody WaterPurchase purchase) {
        if (purchase.getVolumeLiters() != null && purchase.getUnitCostPerLiter() != null) {
            purchase.setTotalCost(purchase.getVolumeLiters() * purchase.getUnitCostPerLiter());
        }
        return repository.save(purchase);
    }

    @GetMapping("/apartment/{apartmentId}")
    public List<WaterPurchase> getPurchases(@PathVariable Long apartmentId) {
        return repository.findByApartmentId(apartmentId);
    }
}