package com.watermonitor.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendPaymentReceipt(String toEmail, String residentName, double amount) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("mayankdwivedi24@gmail.com");
            message.setTo(toEmail);
            message.setSubject("Water Monitor - Payment Receipt & Invoice");
            message.setText("Hello " + residentName + ",\n\n" +
                    "Your water bill payment of ₹" + amount + " has been successfully processed.\n\n" +
                    "Status: PAID\n" +
                    "Email Registered: " + toEmail + "\n\n" +
                    "Regards,\nWater Monitor Team");

            mailSender.send(message);
            System.out.println(">>> SUCCESS: Mail sent successfully to " + toEmail);
            return true;
        } catch (Exception e) {
            System.err.println(">>> ERROR: Failed to send email!");
            e.printStackTrace();
            return false;
        }
    }
}