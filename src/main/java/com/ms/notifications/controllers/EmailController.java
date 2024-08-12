package com.ms.notifications.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email/v1")
public class EmailController {

    @PostMapping("/send")
    public ResponseEntity<?> send() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
