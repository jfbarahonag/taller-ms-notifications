package com.ms.notifications.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.notifications.controllers.docs.EmailDoc;
import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.dto.EmailStatusDto;
import com.ms.notifications.services.EmailService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/email")
public class EmailController implements EmailDoc {

    private final EmailService emailService;

    @Override
    @PostMapping("/send")
    public ResponseEntity<EmailStatusDto> send(@RequestBody EmailDto emailDto) {
        
        EmailStatusDto status = emailService.sendSimpleEmail(emailDto);
        
        if (!status.success()) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
