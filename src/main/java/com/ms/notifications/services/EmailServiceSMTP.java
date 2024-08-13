package com.ms.notifications.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceSMTP implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceSMTP(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleEmail(String to, String subject, String text) {
    }

}
