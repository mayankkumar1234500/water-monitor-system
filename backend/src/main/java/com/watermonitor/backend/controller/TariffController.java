package com.watermonitor.backend.controller;

import com.watermonitor.backend.dto.TariffRequest;
import com.watermonitor.backend.entity.TariffPlan;
import com.watermonitor.backend.service.TariffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {

    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping
    public TariffPlan setTariff(@RequestBody TariffRequest request) {
        return tariffService.setTariff(request);
    }
}