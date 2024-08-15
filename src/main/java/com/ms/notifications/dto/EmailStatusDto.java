package com.ms.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO , Pasar el DTO a Records - Viernes
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailStatusDto {
    private boolean success;
    private String details;
}
