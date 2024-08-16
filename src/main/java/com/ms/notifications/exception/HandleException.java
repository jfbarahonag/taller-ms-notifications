package com.ms.notifications.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.notifications.dto.ErrorDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandleException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getObjectName() + " : " + err.getField() + " : " + err.getDefaultMessage())
                .toList();
        
        log.error("Validation error(s):\n{}" + errors);
        
        return ResponseEntity.badRequest().body(errors);
    }
    
    @ExceptionHandler(MailException.class)
    public ResponseEntity<ErrorDto> handleEmailException(MailException ex) {
        ErrorDto errDto = ErrorDto
                .builder()
                .message(ex.getLocalizedMessage())
                .build();
        
        log.error("Mail error:\n{}", errDto.message());
        
        return ResponseEntity.badRequest().body(errDto);
    }
}
