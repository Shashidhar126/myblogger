package com.example.demo.controller;

import com.example.demo.payload.SmsRequest;
import com.example.demo.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.exception.TwilioException;

@RestController
public class SmsController {
    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @Autowired
    private SmsService smsService;

    @PostMapping("/send-sms")//http://localhost:8080/send-sms
    public void sendSms(@RequestBody SmsRequest smsRequest)  {
        smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
    }
}
