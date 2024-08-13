package com.ms.notifications.services;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
}
