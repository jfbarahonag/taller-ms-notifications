package com.ms.notifications.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.dto.EmailStatusDto;

@Service
public class EmailServiceSMTP implements EmailService {

    @Value("${spring.mail.username}")
    private String sender;
    private final JavaMailSender javaMailSender;

    public EmailServiceSMTP(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public EmailStatusDto sendSimpleEmail(EmailDto emailDto) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDto.getTo().toArray(String[]::new));
            mailMessage.setBcc(emailDto.getBcc().toArray(String[]::new));
            mailMessage.setSubject(emailDto.getSubject());
            mailMessage.setText(emailDto.getBody());
            // Sending the mail
            javaMailSender.send(mailMessage);
            return EmailStatusDto
                    .builder()
                    .success(true)
                    .details("Email sent successfully")
                    .build();
        } catch (MailSendException e) {
            return EmailStatusDto
                    .builder()
                    .success(false)
                    .details("Failure sending the email")
                    .build();
        } catch (MailParseException e) {
            return EmailStatusDto
                    .builder()
                    .success(false)
                    .details("Failure parsing the email")
                    .build();
        } catch (MailAuthenticationException e) {
            return EmailStatusDto
                    .builder()
                    .success(false)
                    .details("Failure authenticating")
                    .build();
        }
    }

}
