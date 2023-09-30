package com.example.demo.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.accountSid}")//@value will go to properties file and pick the value and will initialize variable
    private String accountSid;
    @Value("${twilio.authToken}")//@value will go to properties file and pick the value and will initialize variable
    private String authToken;
    @Value("${twilio.phoneNumber}")//@value will go to properties file and pick the value and will initialize variable
    private String twilioPhoneNumber;



    public void sendSms(String to, String message) {//help us to login into twillio account
        Twilio.init(accountSid,authToken);
        Message.creator(
                        new PhoneNumber(to),
                        new PhoneNumber(twilioPhoneNumber),
                        message)
                .create();
    }
}

