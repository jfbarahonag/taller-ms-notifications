package com.ms.notifications.dto;

import java.util.List;

import lombok.Builder;

@Builder
public record EmailDto(
    List<String> to,
    List<String> bcc,
    String subject,
    String body
) {
}
