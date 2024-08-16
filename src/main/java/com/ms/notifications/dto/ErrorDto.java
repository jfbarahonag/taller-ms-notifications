package com.ms.notifications.dto;

import lombok.Builder;

@Builder
public record ErrorDto(
    String message
) {

}
