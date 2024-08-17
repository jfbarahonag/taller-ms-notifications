package com.ms.notifications.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.dto.EmailStatusDto;
import com.ms.notifications.model.EmailEntity;
import com.ms.notifications.repository.EmailRepository;

@Service
public class EmailServiceSMTP implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;

    public EmailServiceSMTP(JavaMailSender javaMailSender, EmailRepository emailRepository) {
        this.javaMailSender = javaMailSender;
        this.emailRepository = emailRepository;
    }

    @Override
    public EmailStatusDto sendSimpleEmail(EmailDto emailDto) {
        
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(emailDto.to().toArray(String[]::new));
        mailMessage.setBcc(emailDto.bcc().toArray(String[]::new));
        mailMessage.setSubject(emailDto.subject());
        mailMessage.setText(emailDto.body());
        
        // register the log
        EmailEntity log = EmailEntity
                .builder()
                .destination(String.join(",", mailMessage.getTo()))
                .body(mailMessage.getText())
                .subject(mailMessage.getSubject())
                .build();
        emailRepository.save(log);
        
        // Sending the mail
        javaMailSender.send(mailMessage);
        return EmailStatusDto
                .builder()
                .success(true)
                .details("Email sent successfully")
                .build();
        
    }

}
