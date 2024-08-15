package com.ms.notifications.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO , Pasar el DTO a Records - Viernes
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
    private List<String> to;
    private List<String> bcc;
    private String subject;
    private String body;
}
