package com.ms.notifications.dto;

import lombok.Builder;

@Builder
public record EmailStatusDto (
    boolean success,
    String details
) {
}
