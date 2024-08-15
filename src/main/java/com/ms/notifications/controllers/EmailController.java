package com.ms.notifications.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.notifications.controllers.docs.EmailDoc;
import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.services.EmailService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/email/v1")
public class EmailController implements EmailDoc {

    private EmailService emailService;

    @Override
    @PostMapping("/send")
    public ResponseEntity<Object> send(@RequestBody EmailDto emailDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
