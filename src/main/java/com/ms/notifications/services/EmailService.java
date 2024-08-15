package com.ms.notifications.services;

import com.ms.notifications.dto.EmailDto;
import com.ms.notifications.dto.EmailStatusDto;

public interface EmailService {
    EmailStatusDto sendSimpleEmail(EmailDto emailDto);
}
