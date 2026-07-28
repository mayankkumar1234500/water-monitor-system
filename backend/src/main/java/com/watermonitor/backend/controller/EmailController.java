package com.watermonitor.backend.controller;

import com.watermonitor.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-payment")
    public String sendPaymentEmail(@RequestBody Map<String, Object> payload) {
        String toEmail = (String) payload.get("toEmail");
        String residentName = (String) payload.get("residentName");
        double amount = Double.parseDouble(payload.get("amount").toString());

        boolean isSent = emailService.sendPaymentReceipt(toEmail, residentName, amount);
        if (isSent) {
            return "Email Sent Successfully";
        } else {
            return "Email Sending Failed - Check Console";
        }
    }
}